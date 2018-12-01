package org.foresee.dbs.collect;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class SoupUrl {
    public static void main(String[] args) {
        Document doc = null;
        try {
            doc = Jsoup.connect("https://www.gushiwen.org/shiwen/default_4A111111111111A3.aspx").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String title = doc.title();
        System.out.println(title);
        System.out.println(doc.body().select("p").size());
    }
}
