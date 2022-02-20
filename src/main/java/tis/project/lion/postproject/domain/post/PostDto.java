package tis.project.lion.postproject.domain.post;

import tis.project.lion.postproject.domain.board.Board;
import tis.project.lion.postproject.domain.board.BoardDto;

public class PostDto {

    private String title;

    private String writer;

    private String content;

    public PostDto(String title, String writer, String content) {
        this.title = title;
        this.writer = writer;
        this.content = content;
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
