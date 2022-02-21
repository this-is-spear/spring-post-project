package tis.project.lion.postproject.api.controller.post;

import org.springframework.web.bind.annotation.*;
import tis.project.lion.postproject.api.controller.ApiResult;
import tis.project.lion.postproject.domain.post.Post;
import tis.project.lion.postproject.service.PostService;

import static tis.project.lion.postproject.api.controller.ApiResult.*;

@RestController
@RequestMapping("/post")
public class PostControllerImpl implements PostController{
	private final PostService postService;
	public PostControllerImpl(PostService postService) {
		this.postService = postService;
	}

	@Override
	@GetMapping("post-one/{post_id}")
	public ApiResult<PostDto> getPostOne(@PathVariable Long post_id) {
		Post post = postService.findPostOne(post_id);
		return OK(getPostDto(post));
	}

	@Override
	@PostMapping("/create")
	public ApiResult<PostDto> createPost(@RequestBody PostRequest postRequest) {
		Post post = postService.createPost(postRequest.convertPost());
		return OK(getPostDto(post));
	}

	@Override
	@PatchMapping("/{post_id}")
	public ApiResult<PostDto> editPost(@PathVariable Long post_id, @RequestBody PostDto postDto) {
		Post post = postService.editPost(post_id, postDto.convertPost());
		return OK(getPostDto(post));
	}

	@Override
	@DeleteMapping("/{post_id}")
	public ApiResult<String> deletePost(@PathVariable Long post_id) {
		postService.deletePost(post_id);
		return OK("삭제 성공");
	}

	private PostDto getPostDto(Post post) {
		return post.convertPostDto();
	}

}
