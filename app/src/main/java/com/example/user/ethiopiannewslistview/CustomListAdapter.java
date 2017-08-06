package com.example.user.ethiopiannewslistview;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 5/21/2017.
 */

public class CustomListAdapter extends ArrayAdapter<NewsData> {
    ArrayList<NewsData> newsDatas;
    Context context;
    int resource;

    public CustomListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<NewsData> newsDatas) {
        super(context, resource, newsDatas);
        this.newsDatas = newsDatas;
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.custom_list_layout, null, true);
        }
        NewsData newsData = getItem(position);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageview_top_news);
        Picasso.with(context).load(newsData.getImage()).into(imageView);
        TextView news_title = (TextView) convertView.findViewById(R.id.textview_news_title);
        news_title.setText(newsData.getTitle());
        TextView news_date = (TextView) convertView.findViewById(R.id.textview_news_date);
        news_date.setText(newsData.getDate());

        return convertView;
    }
}
