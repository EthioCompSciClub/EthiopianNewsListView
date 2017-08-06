package com.example.user.ethiopiannewslistview;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<NewsData> news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list_view);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(), news.get(position).getLink(), Toast.LENGTH_LONG).show();
                Uri uri = Uri.parse(news.get(position).getLink());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        new mytask().execute();

    }

    class mytask extends AsyncTask<Void, Void, ArrayList<NewsData>>{
        @Override
        protected ArrayList<NewsData> doInBackground(Void... params) {
            ArrayList<NewsData> temp = new NewsFetch().FetchTopNews();
            return temp;
        }

        @Override
        protected void onPostExecute(ArrayList<NewsData> newsDatas) {
            CustomListAdapter customListAdapter = new CustomListAdapter(getApplicationContext(),
                    R.layout.custom_list_layout,
                    newsDatas);
            news = new ArrayList<NewsData>(newsDatas);
            listView.setAdapter(customListAdapter);
        }
    }


}
