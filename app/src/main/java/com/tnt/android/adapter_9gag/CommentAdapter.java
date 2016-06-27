package com.tnt.android.adapter_9gag;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by USER on 26.6.2016 г..
 */
public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentsHolder> {

    ArrayList<String> comments;

    public CommentAdapter(Context context, ArrayList<String> comments) {
        this.comments = comments;
    }

    @Override
    public CommentsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment, parent, false);
        CommentsHolder holder = new CommentsHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(CommentsHolder holder, int position) {
        String comment= comments.get(position);
        holder.txtContent.setText(comment);
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public class CommentsHolder extends RecyclerView.ViewHolder {

        TextView txtContent;

        public CommentsHolder(View itemView) {
            super(itemView);
            txtContent = (TextView) itemView.findViewById(R.id.txt_content);
        }
    }
}
