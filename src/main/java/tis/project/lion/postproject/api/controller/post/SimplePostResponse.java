package tis.project.lion.postproject.api.controller.post;

public class SimplePostResponse {
	private final String url;

	private final String title;

	private final String writer;

	private static final String HOST = "http://localhost:8080/posts/";

	public SimplePostResponse(String url, String title, String writer) {
		this.url = url;
		this.title = title;
		this.writer = writer;
	}

	public static SimplePostResponse createPostResponse(Long id, String title, String writer) {
		return new SimplePostResponse(HOST +id, title, writer);
	}

	public String getUrl() {
		return url;
	}

	public String getTitle() {
		return title;
	}

	public String getWriter() {
		return writer;
	}
}
