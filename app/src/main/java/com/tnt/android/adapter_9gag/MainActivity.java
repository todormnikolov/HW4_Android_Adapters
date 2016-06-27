package com.tnt.android.adapter_9gag;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @Bind(R.id.rec_view)
    RecyclerView recView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        List<Post> posts = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            Post newPost = new Post("Title " + i);

            for (int j = 1; j < 50; j++) {
                Comment comment = new Comment("Comment " + j);
                newPost.addComment(comment);
            }

            posts.add(newPost);
        }

        recView.setLayoutManager(new LinearLayoutManager(this));
        recView.setAdapter(new PostAdapter(this, posts));
    }
}
