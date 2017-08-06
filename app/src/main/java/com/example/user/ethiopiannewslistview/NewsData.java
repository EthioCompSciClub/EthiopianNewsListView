package com.example.user.ethiopiannewslistview;

/**
 * Created by User on 5/21/2017.
 */

public class NewsData {
    private String image;
    private String title;
    private String date;
    private String link;

    public NewsData(String image, String title, String date, String link) {
        this.image = image;
        this.title = title;
        this.date = date;
        this.link = link;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
