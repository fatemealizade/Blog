package com.example.blog;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
        public View getView(final int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = getLayoutInflater().inflate(R.layout.post_item, viewGroup, false);
            }

            ((TextView) view.findViewById(R.id.post_txt)).setText(Integer.toString(i));
            Button btn = view.findViewById(R.id.post_btn);

            btn.setText("Button " + Integer.toString(i + 1));
            if (i % 2 == 0) {
                btn.setBackgroundColor(Color.rgb(0, 100, 255));
            } else {
                btn.setBackgroundColor(Color.YELLOW);
            }
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, Integer.toString(i), Toast.LENGTH_SHORT).show();
                }
            });
            return view;
        }
    }

}
