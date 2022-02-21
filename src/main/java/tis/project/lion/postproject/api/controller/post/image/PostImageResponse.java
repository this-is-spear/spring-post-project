package tis.project.lion.postproject.api.controller.post.image;

import tis.project.lion.postproject.domain.image.PostImage;

public class PostImageResponse {

	private static final String fileDir = "/Users/keonchanglee/Desktop/upload-file/";
	private static final String HOST = "http://localhost:8080/posts/";

	private final String uploadFileName;
	private final String filePath;
	private final String url;

	private PostImageResponse(String uploadFileName, String filePath, String url) {
		this.uploadFileName = uploadFileName;
		this.filePath = filePath;
		this.url = url;
	}

	public static PostImageResponse postImagerequest(Long id, String uploadFileName, String storeFileName) {
		return new PostImageResponse(HOST + id, uploadFileName, fileDir + storeFileName);
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public String getUrl() {
		return url;
	}

	public static PostImageResponse convertPostImageToPostImageRequest(PostImage postImage) {
		return postImagerequest(postImage.getId(), postImage.getUploadFileName(), postImage.getStoreFileName());
	}
}
