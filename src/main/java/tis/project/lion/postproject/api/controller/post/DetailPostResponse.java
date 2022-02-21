package tis.project.lion.postproject.api.controller.post;


import tis.project.lion.postproject.domain.post.Post;

public class DetailPostResponse {

    private final String title;

    private final String writer;

    private final String content;

    public DetailPostResponse(String title, String writer, String content) {
        this.title = title;
        this.writer = writer;
        this.content = content;
    }

    public static DetailPostResponse createDetailPostResponse(String title, String writer, String content) {
        return new DetailPostResponse(title, writer, content);
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

    public Post convertPost() {
        return new Post(this.title, this.writer, this.content);
    }
}
