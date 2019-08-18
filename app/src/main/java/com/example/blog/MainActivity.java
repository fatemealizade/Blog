package com.example.blog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.blog.data.DataHandler;
import com.example.blog.models.Post;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView postsLst = findViewById(R.id.posts_lst);
        postsLst.setAdapter(new PostsAdapter());
    }

    class PostsAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 50;
        }

        @Override
        public Object getItem(int i) {
            return i;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = new TextView(MainActivity.this);
            }

            ((TextView) view).setText(Integer.toString(i));
            return view;
        }
    }

}
