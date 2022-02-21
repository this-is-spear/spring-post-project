package tis.project.lion.postproject.api.controller.post;

import org.springframework.web.multipart.MultipartFile;
import tis.project.lion.postproject.domain.post.Post;

import java.util.List;

public class PostRequest {

    private String title;

    private String writer;

    private String content;

    private String password;

    private List<MultipartFile> imageFiles;

    public PostRequest(String title, String writer, String content, String password, List<MultipartFile> imageFiles) {
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.password = password;
        this.imageFiles = imageFiles;
    }

    public PostRequest() {
    }

    public List<MultipartFile> getImageFiles() {
        return imageFiles;
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
