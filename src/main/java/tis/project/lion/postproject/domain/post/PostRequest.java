package tis.project.lion.postproject.domain.post;

import tis.project.lion.postproject.domain.board.Board;

public class PostRequest {

    private final Board board;

    private final String title;

    private final String writer;

    private final String content;

    private final String password;

    public PostRequest(Board board, String title, String writer, String content, String password) {
        this.board = board;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.password = password;
    }

    public Post convertPost() {
        return new Post(this.board, this.title, this.writer, this.content, this.password);
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
}
