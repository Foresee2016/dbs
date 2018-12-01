package org.foresee.dbs.collect;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PoetryHtmlFile {
    public static void main(String[] args) {
        try {
            PoetryHtmlFile poetryFile = PoetryHtmlFile.parse("E:/temp/html/poetry6.html");
            List<Article> articles = poetryFile.getArticles();
            for (Article article : articles) {
                System.out.println(article.title);
                System.out.println(article.writtenTime);
                System.out.println(article.author);
                for (Paragraph p : article.paragraphs) {
                    System.out.println(p.content);
                    System.out.println(p.translate);
                    for (String m : p.memos) {
                        System.out.println(m);
                    }
                    System.out.println();
                }
                System.out.println(String.join("，", article.theme));
                System.out.println();
                for (String t : article.appreciate) {
                    System.out.println(t);
                }
                System.out.println("-------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Document doc;

    private PoetryHtmlFile(Document doc) {
        this.doc = doc;
    }

    public static PoetryHtmlFile parse(String filename) throws IOException {
        File file = new File(filename);
        Document doc = Jsoup.parse(file, "UTF-8");
        return new PoetryHtmlFile(doc);
    }

    public List<Article> getArticles() {
        Elements arts = doc.body().select(".sons");
        List<Article> articles = new ArrayList<>();
        for (int i = 0; i < arts.size(); i++) {
            articles.add(getArticle(arts.get(i)));
        }
        return articles;
    }

    private Article getArticle(Element art) {
        Article article = new Article();
        Elements title = art.select(".cont > p").eq(0);
        article.title = title.text();
        Elements timeAuthor = art.select(".cont > p").eq(1);
        String writtenTime = timeAuthor.select("a").eq(0).text();
        article.writtenTime = writtenTimeMap.containsKey(writtenTime) ? writtenTimeMap.get(writtenTime) : Arrays.asList(writtenTime);
        article.author = Arrays.asList(timeAuthor.select("a").eq(1).text());
        article.paragraphs = getParas(art);
        article.theme = getTheme(art);
        article.appreciate = getAppreciate(art);
        return article;
    }

    private String PATTERN_STR = "<span.+?</span>";
    private Pattern pattern = Pattern.compile(PATTERN_STR);

    private List<Paragraph> getParas(Element art) {
        List<Paragraph> paras = new ArrayList<>();
        Elements cont = art.select(".cont .contson > p:has(br)");
        for (int i = 0; i < cont.size(); i++) {
            Paragraph para = new Paragraph();
            Element p = cont.get(i); //获取一段，其中包含正文、音标、翻译、注释
            String html = p.html(); //内部所有html
            String c = html.substring(0, html.indexOf("<br>")); //截断第一个br之前，为正文
            //提出音标进Map
            Map<String, String> pronMap = new HashMap<>();
            Matcher matcher = pattern.matcher(c);
            int pronCnt = -1;
            while (matcher.find()) {
                int pos = matcher.start();
                pronCnt++;
                String proned = c.substring(pos - 1, pos);
                String pron = p.select("span[style='color:#286345;']").eq(pronCnt).text();
                pronMap.put(proned, pron);
            }
            para.content = c.replaceAll(PATTERN_STR, "").replaceAll("\\(.*?\\)", ""); //去掉音标以及括号
            para.content=para.content.replaceAll("　", ""); //去掉全角空格
            para.translate = p.select("span[style='color:#76621c;']").text();
            para.translate=para.translate.replaceAll("　", ""); //去掉全角空格
            Elements m = p.select("span[style='color:#286345;']");
            if (m.size() > 0) {
                String[] memos = m.last().text().split("。");
                for (int j = 0; j < memos.length; j++) {
                    memos[j] = memos[j] + "。"; //把被分的句号填上
                    memos[j]=memos[j].replaceAll("　", "");//去掉全角空格
                }
                List<String> colon = new ArrayList<>();
                //以句号分隔时，有些注释被分开，遍历，对没有冒号的，拼到前一个后面。
                for (int j = 0; j < memos.length; j++) {
                    memos[j] = memos[j].replaceAll(":", "："); //错打英文冒号的，换成中文冒号
                    if (memos[j].contains("：")) {
                        colon.add(memos[j]);
                    } else {
                        if (j < 1) {
                            System.err.println("第一个不包含冒号，无法向前拼合。memo=" + memos[j]);
                            continue;
                        }
                        int to = colon.size() - 1;
                        colon.set(to, colon.get(to) + memos[j]);
                    }
                }
                List<String> merge = new ArrayList<>();
                for (int j = 0; j < colon.size(); j++) {
                    String memo = colon.get(j);
                    // 查找音标Map，如果有，拼进去
                    String pron = null, proned = null;
                    int pos = -1;
                    for (String key : pronMap.keySet()) {
                        pos = memo.indexOf(key);
                        if (pos >= 0) { //以前面为准，比如重字的如，皎(jiǎo)皎，注前面的，后面不注。
                            pron = pronMap.get(key);
                            proned = key;
                            break;
                        }
                    }
                    if (pos >= 0) {
                        memo = memo.replaceFirst(proned, proned + pron);
                        pronMap.remove(proned);
                    }
                    merge.add(memo);
                }
                //对于有音标，但没匹配到注释里的，单独成一个注释
                for (String proned : pronMap.keySet()) {
                    merge.add(proned + pronMap.get(proned) + "。");
                }
                para.memos.addAll(merge);
            }
            paras.add(para);
        }
        return paras;
    }

    private List<String> getTheme(Element art) {
        Elements as = art.select(".tag a");
        List<String> theme = new ArrayList<>();
        for (int i = 0; i < as.size(); i++) {
            theme.add(as.get(i).text());
        }
        return theme;
    }

    private List<String> getAppreciate(Element art) {
        Elements ps = art.select(".cont .contson p").not(":has(br)").not("[style]");
        List<String> appres = new ArrayList<>();
        for (int i = 0; i < ps.size(); i++) {
            //这里把全角空格字符替换掉。
            appres.add(ps.get(i).text().replaceAll("　", "").replace("\t", ""));
        }
        return appres;
    }

    public static class Article {
        String title;
        List<String> author;
        List<String> writtenTime;
        List<Paragraph> paragraphs;
        String style;
        List<String> theme;
        List<String> appreciate;
    }

    public static class Paragraph {
        String content;
        String translate;
        List<String> memos = new ArrayList<>();
    }

    public static final Map<String, List<String>> writtenTimeMap = new HashMap<>();

    static {
        final List<List<String>> links = new ArrayList<>();
        links.add(Arrays.asList("汉代", "两汉", "汉朝", "汉"));
        links.add(Arrays.asList("唐代", "唐朝", "唐"));
        links.add(Arrays.asList("宋代", "两宋", "宋朝", "宋"));
        links.add(Arrays.asList("明代", "明朝", "明"));
        links.add(Arrays.asList("清代", "清朝", "清"));
        for (List<String> link : links) { //不论哪一个，都对应它们全体
            for (String s : link) {
                writtenTimeMap.put(s, link);
            }
        }
        //两半的朝代，也对应上。
        writtenTimeMap.put("西汉", Arrays.asList("西汉", "汉代", "两汉", "汉朝", "汉"));
        writtenTimeMap.put("东汉", Arrays.asList("东汉", "汉代", "两汉", "汉朝", "汉"));
        writtenTimeMap.put("北宋", Arrays.asList("北宋", "两宋", "宋代", "宋朝", "宋"));
        writtenTimeMap.put("南宋", Arrays.asList("南宋", "两宋", "宋代", "宋朝", "宋"));
    }
}
