package kz.bitlab.servlets.db;

import java.sql.Timestamp;

public class News {
    Long id;
    String title;
    String content;
    Users users;
    Timestamp postDate;

    public News() {
    }

    public News(Long id, String title, String content, Users users, Timestamp postDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.users = users;
        this.postDate = postDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Timestamp getPostDate() {
        return postDate;
    }

    public void setPostDate(Timestamp postDate) {
        this.postDate = postDate;
    }
}