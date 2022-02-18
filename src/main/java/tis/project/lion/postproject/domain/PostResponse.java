package tis.project.lion.postproject.domain;

public class PostResponse {

    private final String title;

    private final String writer;

    private final String Content;

    public PostResponse(String title, String writer, String content) {
        this.title = title;
        this.writer = writer;
        Content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getWriter() {
        return writer;
    }

    public String getContent() {
        return Content;
    }

}
