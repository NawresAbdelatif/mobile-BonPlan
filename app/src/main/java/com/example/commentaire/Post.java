package com.example.commentaire;

import java.util.ArrayList;

public class Post {
    private int id;
    private String title;
    private String description;
    private ArrayList<Comment> comments;

    public Post(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.comments = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }
}
