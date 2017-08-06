package com.example.user.ethiopiannewslistview;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by User on 5/21/2017.
 */

public class NewsFetch {
    private ArrayList<NewsData> data;

    String url;
    private Document doc;
    private Elements elem_real;

    public NewsFetch() {
        data = new ArrayList<>();
        url = "http://www.ethiomedia.com";
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        elem_real = doc.getElementsByClass("article");
    }

    public ArrayList<NewsData> FetchTopNews(){

        for(int i=0; i<elem_real.size(); i++){
            String temp_image = "";
            temp_image = elem_real.get(i).child(0).child(0).attributes().get("src");
            System.out.println(temp_image);
            String temp_title = elem_real.get(i).child(1).child(0).child(0).text();
            System.out.println(temp_title);
            String temp_date = elem_real.get(i).child(1).child(1).text();
            System.out.println(temp_date);
            String temp_link = elem_real.get(i).child(1).child(0).child(0).attributes().get("href");
            System.out.println(temp_link);
            NewsData temp = new NewsData(temp_image, temp_title, temp_date, temp_link);
            data.add(temp);
        }
        //System.out.println(data.isEmpty());
       return data;
    }



}
