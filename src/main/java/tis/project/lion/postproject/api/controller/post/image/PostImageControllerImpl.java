package tis.project.lion.postproject.api.controller.post.image;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tis.project.lion.postproject.api.controller.ApiResult;
import tis.project.lion.postproject.domain.image.PostImage;
import tis.project.lion.postproject.domain.post.Post;

import java.util.List;

@RestController
@RequestMapping("/posts/{postId}")
public class PostImageControllerImpl implements PostImageController{

	@Override
	@PostMapping("/images")
	public ApiResult<Post> save(@PathVariable Long postId, @RequestPart List<MultipartFile> multipartFileList) {
		return null;
	}

	@Override
	@GetMapping("/images")
	public ApiResult<List<PostImage>> findByPostId(@PathVariable Long postId) {
		return null;
	}

	@Override
	@GetMapping("/images/{imageId}")
	public ApiResult<PostImage> findById(@PathVariable Long postId, @PathVariable Long imageId) {
		return null;
	}
}
