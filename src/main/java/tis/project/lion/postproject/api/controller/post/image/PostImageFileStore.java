package tis.project.lion.postproject.api.controller.post.image;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import tis.project.lion.postproject.domain.image.PostImage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class PostImageFileStore {

	@Value("${file.dir}")
	private String fileDir;

	private String getFullPath(String filename) {
		return fileDir + filename;
	}

	public List<PostImage> storeFiles(List<MultipartFile> multipartFileList) throws IOException {
		List<PostImage> storeFileResult = new ArrayList<>();
		for (MultipartFile multipartFile : multipartFileList) {
			if (!multipartFile.isEmpty()) {
				storeFileResult.add(storeFile(multipartFile));
			}
		}
		return storeFileResult;
	}

	private PostImage storeFile(MultipartFile multipartFile) throws IOException{
		if (multipartFile.isEmpty()) {
			return null;
		}

		String originalFilename = multipartFile.getOriginalFilename();
		String storeFileName = createStoreFileName(originalFilename);
		multipartFile.transferTo(new File(getFullPath(storeFileName)));

		return new PostImage(originalFilename, storeFileName);
	}

	private String createStoreFileName(String originalFilename) {
		String extractExt = extractExt(originalFilename);
		String uuid = UUID.randomUUID().toString();
		return uuid + "." + extractExt;
	}

	private String extractExt(String originalFilename) {
		int pos = originalFilename.lastIndexOf(".");
		return originalFilename.substring(pos + 1);
	}

}
