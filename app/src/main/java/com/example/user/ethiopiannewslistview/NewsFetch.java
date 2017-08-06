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
    private Elements elem_cost;
    private Elements elem_real;
    private Elements other_news;

    public NewsFetch() {
        data = new ArrayList<>();
        url = "http://www.ethiomedia.com";
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        elem_cost = doc.select("a.cost");
        elem_real = doc.select("a.real");
        other_news = doc.select("a");
    }

    public ArrayList<NewsData> FetchTopNews(){

        for(int i=0; i<elem_real.size(); i++){
            String temp_image = "";
            if(elem_cost.get(i).select("img").hasAttr("src")){
                temp_image = url + elem_cost.get(i).select("img").attr("src");
                //System.out.println(temp_image);
            }
            String temp_title = elem_real.get(i).text();
            //System.out.println(temp_title);
            String temp_date = "Top News";
            //System.out.println(temp_date);
            String temp_link = url + elem_real.get(i).attr("href");
            //System.out.println(temp_link);
            NewsData temp = new NewsData(temp_image, temp_title, temp_date, temp_link);
            data.add(temp);
        }
        //System.out.println(data.isEmpty());
       return data;
    }

    public ArrayList<NewsData> FetchOtherNews(){
        String temp_date = "";
        String temp_image = url + doc.select("table").select("img").first().attr("src");
        for(int i=0; i<other_news.size(); i++){
            if(other_news.get(i).hasClass("stream") && temp_date.isEmpty()){
                temp_date = other_news.get(i).text();
            }else if(!temp_date.isEmpty() && other_news.get(i).hasClass("stream")){
                break;
            }
            String temp_title = "";
            String temp_link = "";
            if(!temp_date.isEmpty() && other_news.get(i).hasClass("cost")){
                temp_title = other_news.get(i).text();
                temp_link = url + other_news.get(i).attr("href");
            }
            if(!temp_title.isEmpty()) {
                NewsData temp = new NewsData(temp_image, temp_title, temp_date, temp_link);
                data.add(temp);
            }
        }
        return data;
    }

}
