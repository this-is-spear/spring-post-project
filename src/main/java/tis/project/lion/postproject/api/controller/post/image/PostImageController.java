package tis.project.lion.postproject.api.controller.post.image;

import org.springframework.web.multipart.MultipartFile;
import tis.project.lion.postproject.api.controller.ApiResult;
import tis.project.lion.postproject.domain.image.PostImage;
import tis.project.lion.postproject.domain.post.Post;

import java.util.List;

public interface PostImageController {
	ApiResult<Post> save(Long postId, List<MultipartFile> multipartFileList);

	ApiResult<List<PostImage>> findByPostId(Long postId);

	ApiResult<PostImage> findById(Long postId, Long postImageId);
}
