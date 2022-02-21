package tis.project.lion.postproject.api.controller.post;

import tis.project.lion.postproject.domain.post.Post;

public class PostRequest {

    private String title;

    private String writer;

    private String content;

    private String password;

    public PostRequest(String title, String writer, String content, String password) {
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.password = password;
    }

    public PostRequest() {
    }

    public String getTitle() {
        return title;
    }

    public String getWriter() {
        return writer;
    }

    public String getContent() {
        return content;
    }

    public String getPassword() {
        return password;
    }

    public Post convertPost() {
        return new Post(this.title, this.writer, this.content, this.password);
    }
}
