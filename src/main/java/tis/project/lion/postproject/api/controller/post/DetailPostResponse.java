package tis.project.lion.postproject.api.controller.post;


import tis.project.lion.postproject.api.controller.post.image.PostImageResponse;
import tis.project.lion.postproject.domain.post.Post;

import java.util.List;

public class DetailPostResponse {

    private final String title;

    private final String writer;

    private final String content;

    private final List<PostImageResponse> imageList;

    public DetailPostResponse(String title, String writer, String content, List<PostImageResponse> imageList) {
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.imageList = imageList;
    }

    public static DetailPostResponse createDetailPostResponse(String title, String writer, String content, List<PostImageResponse> imageList) {
        return new DetailPostResponse(title, writer, content, imageList);
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

    public List<PostImageResponse> getImageList() {
        return imageList;
    }

    public Post convertPost() {
        return new Post(this.title, this.writer, this.content);
    }
}
