package tis.project.lion.postproject.api.controller.post.image;

import tis.project.lion.postproject.domain.image.PostImage;

public class PostImageResponse {

//	private static final String fileDir = "/Users/keonchanglee/Desktop/upload-file/";
	private static final String HOST = "http://localhost:8080/posts/there's_image_path";

	private final String uploadFileName;
	private final String filePath;
	private final String storeFileName;

	private PostImageResponse(String uploadFileName, String filePath, String storeFileName) {
		this.uploadFileName = uploadFileName;
		this.filePath = filePath;
		this.storeFileName = storeFileName;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public String getStoreFileName() {
		return storeFileName;
	}

	public static PostImageResponse postImageResponse(Long id, String uploadFileName, String storeFileName) {
		return new PostImageResponse(HOST + id, uploadFileName,  storeFileName);
	}

	public static PostImageResponse convertPostImageToPostImageRequest(PostImage postImage) {
		return postImageResponse(postImage.getId(), postImage.getUploadFileName(), postImage.getStoreFileName());
	}
}
