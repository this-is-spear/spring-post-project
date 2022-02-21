package tis.project.lion.postproject.api.controller.post;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tis.project.lion.postproject.api.controller.ApiResult;
import tis.project.lion.postproject.api.controller.post.image.PostImageFileStore;
import tis.project.lion.postproject.domain.post.Post;
import tis.project.lion.postproject.service.PostService;

import java.io.IOException;

import static tis.project.lion.postproject.api.controller.ApiResult.*;

@Slf4j
@RestController
@RequestMapping("/posts")
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

//	@Override
	@PostMapping
	public ApiResult<DetailPostResponse> createPost(@RequestBody PostRequest postRequest) throws IOException {
		Post convertPost = postRequest.convertPost();
		log.info("[{}][{}]", convertPost.getTitle(), convertPost.getContent());
		Post post = postService.createPost(convertPost);
		return OK(getDetailPostResponse(post));
	}

	@Override
	@PatchMapping("/{postId}")
	public ApiResult<DetailPostResponse> editPost(@PathVariable Long postId, @ModelAttribute DetailPostResponse postDto) {
		Post post = postService.editPost(postId, postDto.convertPost());
		return OK(getDetailPostResponse(post));
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

}
