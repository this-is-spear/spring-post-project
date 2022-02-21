package tis.project.lion.postproject.api.controller.post;

import org.springframework.web.multipart.MultipartFile;
import tis.project.lion.postproject.domain.post.Post;

import java.util.ArrayList;
import java.util.List;

public class PostRequest {

    private String title;

    private String writer;

    private String content;

    private String password;

    private List<MultipartFile> imageFiles = new ArrayList<>();

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


    public void setTitle(String title) {
        this.title = title;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setImageFiles(List<MultipartFile> imageFiles) {
        this.imageFiles = imageFiles;
    }

    public Post convertPost() {
        return new Post(this.title, this.writer, this.content, this.password);
    }
}
