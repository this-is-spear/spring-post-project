package tis.project.lion.postproject.domain.post;

import tis.project.lion.postproject.api.controller.post.DetailPostResponse;
import tis.project.lion.postproject.api.controller.post.SimplePostResponse;
import tis.project.lion.postproject.api.controller.post.image.PostImageResponse;
import tis.project.lion.postproject.domain.board.Board;
import tis.project.lion.postproject.domain.image.PostImage;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
public class Post {
    @Id
    @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostImage> imagesFiles = new ArrayList<>();

    private String title;

    private String writer;

    private String content;

    private String password;

    public Post(Long id, Board board, String title, String writer, String content, String password) {
        this.id = id;
        this.board = board;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.password = password;
    }

    public Post(String title, String writer, String content, String password) {
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.password = password;
    }

    public Post(String title, String writer, String content) {
        this.title = title;
        this.writer = writer;
        this.content = content;
    }

    public Post() {

    }
    public Long getId() {
        return id;
    }

    public Board getBoard() {
        return board;
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

    public List<PostImage> getImagesFiles() {
        return imagesFiles;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setBoard(Board board) {
        this.board = board;
    }

    public DetailPostResponse convertPostToDetailPostResponse() {
        return DetailPostResponse.createDetailPostResponse(this.getTitle(), this.getWriter(), this.getContent(), convertPostImageToPostImageResponse());
    }

    public SimplePostResponse convertPostToSimplePostResponse() {
        return SimplePostResponse.createPostResponse(this.getId(), this.getTitle(), this.getContent());
    }

    public List<PostImageResponse> convertPostImageToPostImageResponse() {
        return this.getImagesFiles().stream().map(PostImageResponse::convertPostImageToPostImageResponse).collect(Collectors.toList());
    }

    public void uploadImage(PostImage postImage) {
        postImage.setPost(this);
        this.getImagesFiles().add(postImage);
    }

    public void setImagesFiles(List<PostImage> imagesFiles) {
        for (PostImage imagesFile : imagesFiles) {
            this.uploadImage(imagesFile);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(getId(), post.getId()) && Objects.equals(getBoard(), post.getBoard()) && Objects.equals(getImagesFiles(), post.getImagesFiles()) && Objects.equals(getTitle(), post.getTitle()) && Objects.equals(getWriter(), post.getWriter()) && Objects.equals(getContent(), post.getContent()) && Objects.equals(getPassword(), post.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBoard(), getImagesFiles(), getTitle(), getWriter(), getContent(), getPassword());
    }
}
