package com.tnt.android.adapter_9gag;

import java.util.ArrayList;
import java.util.List;

public class Post {

    private String title;
    private int points;
    private List<String> comments;

    public Post(String title) {
        this.title = title;
        this.points = 0;
        this.comments = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getCommentsNum() {
        return comments.size();
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public void addComment(Comment comment) {
        this.comments.add(comment.getContent());
    }
}
