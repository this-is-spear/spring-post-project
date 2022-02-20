package tis.project.lion.postproject.domain.post;

import tis.project.lion.postproject.domain.board.Board;

import javax.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

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

    private void setTitle(String title) {
        this.title = title;
    }

    private void setContent(String content) {
        this.content = content;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    private void setBoard(Board board) {
        this.board = board;
    }

    public PostRequest convertPostResponse() {
        return new PostRequest(this.title, this.writer, this.content, this.password);
    }

    public PostDto convertPostDto() {
        return new PostDto(this.getTitle(), this.getWriter(), this.getContent());
    }
}
