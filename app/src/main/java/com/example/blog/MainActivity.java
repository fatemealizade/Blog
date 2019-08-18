package com.example.blog;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.blog.data.DataHandler;
import com.example.blog.models.Post;

public class MainActivity extends AppCompatActivity {
    private Post[] mPosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DataHandler dataHandler = new DataHandler();
        mPosts = dataHandler.getAllPosts();
        ListView postsLst = findViewById(R.id.posts_lst);
        postsLst.setAdapter(new PostsAdapter());
    }

    class PostsAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mPosts.length;
        }

        @Override
        public Post getItem(int i) {
            return mPosts[i];
        }

        @Override
        public long getItemId(int i) {
            return getItem(i).id;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = getLayoutInflater().inflate(R.layout.post_item, viewGroup, false);
            }

            Post post = getItem(i);
            ((TextView) view.findViewById(R.id.post_txt)).setText(post.title);
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
