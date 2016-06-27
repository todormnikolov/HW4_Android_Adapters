package com.tnt.android.adapter_9gag;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 14.6.2016 г..
 */
public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {

    public Context context;
    private List<Post> posts;

    PostAdapter(Context context, List<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    @Override
    public PostHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        PostHolder holder = new PostHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(PostHolder holder, int position) {
        final Post post = posts.get(position);
        holder.txtTitle.setText(post.getTitle());
        holder.txtNumPoints.setText(String.valueOf(post.getPoints()));
        holder.txtNumComments.setText(String.valueOf(post.getCommentsNum()));
        holder.imgBtnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CommentsActivity.class);
                ArrayList<String> comments = (ArrayList<String>) post.getComments();
                intent.putStringArrayListExtra("comments", comments );
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class PostHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView txtTitle;
        TextView txtNumPoints;
        TextView txtNumComments;
        ImageView imgBtnVoteUp;
        ImageView imgBtnVoteDown;
        ImageView imgBtnComment;
        boolean isVoteUp;
        boolean isVoteDown;

        public PostHolder(View itemView) {
            super(itemView);

            isVoteUp = false;
            isVoteDown = false;
            txtTitle = (TextView) itemView.findViewById(R.id.txt_title);
            txtNumPoints = (TextView) itemView.findViewById(R.id.txt_num_points);
            txtNumComments = (TextView) itemView.findViewById(R.id.txt_num_comments);

            imgBtnVoteUp = (ImageView) itemView.findViewById(R.id.img_btn_vote_up);
            imgBtnVoteUp.setOnClickListener(this);
            imgBtnVoteDown = (ImageView) itemView.findViewById(R.id.img_btn_vote_down);
            imgBtnVoteDown.setOnClickListener(this);
            imgBtnComment = (ImageView) itemView.findViewById(R.id.img_btn_comment);

        }

        @Override
        public void onClick(View v) {
            if (v.equals(imgBtnVoteUp) && isVoteUp == false) {

                if (isVoteDown) {
                    imgBtnVoteDown.setImageResource(R.drawable.btn_vote_down);
                    isVoteDown = false;
                }

                imgBtnVoteUp.setImageResource(R.drawable.btn_vote_up_selected);
                isVoteUp = true;
            }

            if (v.equals(imgBtnVoteDown) && isVoteDown == false) {

                if (isVoteUp) {
                    imgBtnVoteUp.setImageResource(R.drawable.btn_vote_up);
                    isVoteUp = false;
                }

                imgBtnVoteDown.setImageResource(R.drawable.btn_vote_down_selected);
                isVoteDown = true;
            }
        }
    }
}
