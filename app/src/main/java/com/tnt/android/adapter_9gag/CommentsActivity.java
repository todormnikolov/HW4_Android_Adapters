package com.tnt.android.adapter_9gag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CommentsActivity extends AppCompatActivity {

    @Bind(R.id.rec_view_comments)
    RecyclerView recViewComments;

    private Button btnSend;
    private EditText editComment;

    ArrayList<String> comments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        ButterKnife.bind(this);

        editComment = (EditText) findViewById(R.id.edit_comment);
        btnSend = (Button) findViewById(R.id.btn_send);

        Intent intent = getIntent();
        comments = intent.getStringArrayListExtra("comments");

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comment = String.valueOf(editComment.getText());
                comments.add(comment);
                setCommentAdapter(recViewComments, comments);
            }
        });

        setCommentAdapter(recViewComments, comments);

    }

    private void setCommentAdapter(RecyclerView recView, ArrayList<String> data) {

        recView.setLayoutManager(new LinearLayoutManager(this));
        recView.setAdapter(new CommentAdapter(this, data));
    }
}
