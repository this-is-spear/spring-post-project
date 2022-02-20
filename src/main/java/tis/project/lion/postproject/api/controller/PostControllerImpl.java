package tis.project.lion.postproject.api.controller;

import org.springframework.web.bind.annotation.*;
import tis.project.lion.postproject.domain.ApiResult;
import tis.project.lion.postproject.domain.post.Post;
import tis.project.lion.postproject.domain.post.PostDto;
import tis.project.lion.postproject.domain.post.PostRequest;
import tis.project.lion.postproject.service.PostService;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/post")
public class PostControllerImpl implements PostController{
	private final PostService postService;
	public PostControllerImpl(PostService postService) {
		this.postService = postService;
	}

	@Override
	@GetMapping("post-list/{board_id}")
	public ApiResult<List<PostDto>> getPostList(@PathVariable Long board_id) {
		List<Post> postList = postService.findPostList(board_id);
		return ApiResult.OK(postList.stream().map(Post::convertPostDto).collect(Collectors.toList()));
	}

	@Override
	@GetMapping("post-one/{post_id}")
	public ApiResult<PostDto> getPostOne(@PathVariable Long post_id) {
		Post post = postService.findPostOne(post_id);
		return ApiResult.OK(post.convertPostDto());
	}

	@Override
	@PostMapping("/create")
	public ApiResult<PostDto> createPost(@RequestBody PostRequest postRequest) {
		Post post = postService.createPost(postRequest.convertPost());
		return ApiResult.OK(post.convertPostDto());
	}

	@Override
	@PatchMapping("/{post_id}")
	public ApiResult<PostDto> editPost(@PathVariable Long post_id, @RequestBody PostDto postDto) {
		Post post = postService.editPost(post_id, postDto.convertPost());
		return ApiResult.OK(postDto);
	}

	@Override
	@DeleteMapping("/{post_id}")
	public ApiResult<String> deletePost(@PathVariable Long post_id) {
		postService.deletePost(post_id);
		return ApiResult.OK("삭제 성공");
	}

}
