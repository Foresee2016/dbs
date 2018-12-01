package org.foresee.dbs.collect;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class SoupLocalFile {
    public static void main(String[] args) {
        try {
            File file=new File("E:/temp/html/learn3.html");
            Document doc = Jsoup.parse(file, "UTF-8");
            String title = doc.title();
            System.out.println(title);
            Elements contents=doc.select("#contsonce802de625e5 p");
            for(int i=0; i<contents.size(); i++){
                Element elem=contents.get(i);
                String text=elem.text();
                System.out.println(text.trim());
//                Pattern rule=Pattern.compile("(.+?)");
//                Matcher matcher=rule.matcher(text);
//                while (matcher.find()){
//                    System.out.println(matcher.group(0));
//                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
