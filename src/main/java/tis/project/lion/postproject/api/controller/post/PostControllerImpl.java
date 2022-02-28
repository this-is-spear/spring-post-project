package tis.project.lion.postproject.api.controller.post;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tis.project.lion.postproject.api.controller.ApiResult;
import tis.project.lion.postproject.api.controller.post.image.PostImageFileStore;
import tis.project.lion.postproject.domain.image.PostImage;
import tis.project.lion.postproject.domain.post.Post;
import tis.project.lion.postproject.service.PostService;

import java.io.IOException;
import java.util.List;

import static tis.project.lion.postproject.api.controller.ApiResult.*;

@Slf4j
@RestController
@RequestMapping("/api/posts")
public class PostControllerImpl implements PostController{
	private final PostService postService;
	private final PostImageFileStore postImageFileStore;

	public PostControllerImpl(PostService postService, PostImageFileStore postImageFileStore) {
		this.postService = postService;
		this.postImageFileStore = postImageFileStore;
	}

	@Override
	@GetMapping("/{postId}")
	public ApiResult<DetailPostResponse> getPostOne(@PathVariable Long postId) {
		Post post = postService.findPostOne(postId);
		return OK(getDetailPostResponse(post));
	}

	@Override
	@PostMapping
	public ApiResult<DetailPostResponse> createPost(@ModelAttribute PostRequest postRequest) throws IOException {
		Post post = postRequest.convertPost();
		if (checkImageFiles(postRequest)) {
			List<PostImage> postImageList = postImageFileStore.storeFiles(postRequest.getImageFiles());
			post.setImagesFiles(postImageList);
		}
		Post createPost = postService.createPost(post);
		return OK(getDetailPostResponse(createPost));
	}

	@Override
	@PatchMapping("/{postId}")
	public ApiResult<DetailPostResponse> editPost(@PathVariable Long postId, @ModelAttribute PostRequest postRequest) throws IOException {
		Post post = postRequest.convertPost();
		if (checkImageFiles(postRequest)) {
			List<PostImage> postImageList = postImageFileStore.storeFiles(postRequest.getImageFiles());
			post.setImagesFiles(postImageList);
		}
		Post editPost = postService.editPost(postId, post);
		return OK(getDetailPostResponse(editPost));
	}

	@Override
	@DeleteMapping("/{postId}")
	public ApiResult<String> deletePost(@PathVariable Long postId) {
		postService.deletePost(postId);
		return OK("삭제 성공");
	}

	private DetailPostResponse getDetailPostResponse(Post post) {
		return post.convertPostToDetailPostResponse();
	}

	private boolean checkImageFiles(PostRequest postRequest) {
		return checkNullImageFiles(postRequest) || checkEmptyImageFiles(postRequest);
	}

	private boolean checkNullImageFiles(PostRequest postRequest) {
		return postRequest.getImageFiles() != null;
	}

	private boolean checkEmptyImageFiles(PostRequest postRequest) {
		return !postRequest.getImageFiles().isEmpty();
	}

}
