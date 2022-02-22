package tis.project.lion.postproject.api.controller.post.image;

import org.springframework.beans.factory.annotation.Value;
import tis.project.lion.postproject.domain.image.PostImage;

public class PostImageResponse {
	private String fileDir = "/Users/keonchanglee/Desktop/upload-file/";

	private String HOST = "http://localhost:8080/posts/{there's_image_path}/";
	private final String uploadFileName;
	private final String filePath;
	private final String storeFilePath;

	private PostImageResponse(String uploadFileName, Long id, String storeFilePath) {
		this.uploadFileName = uploadFileName;
		this.filePath = HOST + id ;
		this.storeFilePath = fileDir + storeFilePath;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public String getStoreFilePath() {
		return storeFilePath;
	}

	public static PostImageResponse postImageResponse( String uploadFileName, Long id, String storeFileName) {
		return new PostImageResponse(uploadFileName, id, storeFileName);
	}

	public static PostImageResponse convertPostImageToPostImageResponse(PostImage postImage) {
		return postImageResponse(postImage.getUploadFileName(), postImage.getId(), postImage.getStoreFileName());
	}
}
