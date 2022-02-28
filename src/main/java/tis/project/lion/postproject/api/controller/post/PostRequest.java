package tis.project.lion.postproject.api.controller.post;

import org.springframework.web.multipart.MultipartFile;
import tis.project.lion.postproject.domain.post.Post;

import java.util.ArrayList;
import java.util.List;

public class PostRequest {

    private final String title;

    private final String writer;

    private final String content;

    private final String password;

    private List<MultipartFile> imageFiles = new ArrayList<>();

    public PostRequest(String title, String writer, String content, String password, List<MultipartFile> imageFiles) {
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.password = password;
        if (imageFiles != null) {
            this.imageFiles = imageFiles;
        }
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
