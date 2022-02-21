package tis.project.lion.postproject.web;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tis.project.lion.postproject.api.controller.ApiResult;
import tis.project.lion.postproject.api.controller.post.DetailPostResponse;
import tis.project.lion.postproject.api.controller.post.PostRequest;
import tis.project.lion.postproject.api.controller.post.image.PostImageFileStore;
import tis.project.lion.postproject.domain.image.PostImage;
import tis.project.lion.postproject.domain.post.Post;
import tis.project.lion.postproject.service.PostService;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import static tis.project.lion.postproject.api.controller.ApiResult.OK;

@Controller
@RequestMapping("/posts")
public class PostViewController {

	private final PostImageFileStore postImageFileStore;
	private final PostService postService;

	public PostViewController(PostImageFileStore postImageFileStore, PostService postService) {
		this.postImageFileStore = postImageFileStore;
		this.postService = postService;
	}

	@GetMapping("/create")
	public String createPostView(@ModelAttribute("postRequest") PostRequest postRequest) {
		return "posts/post-form";
	}

	@PostMapping("/create")
	public String createPost(@ModelAttribute("postRequest") PostRequest postRequest, RedirectAttributes redirectAttributes) throws IOException {
		Post convertPost = postRequest.convertPost();
		List<PostImage> storeFiles = postImageFileStore.storeFiles(postRequest.getImageFiles());
		convertPost.setImagesFiles(storeFiles);
		Post post = postService.createPost(convertPost);
		redirectAttributes.addAttribute("postId", post.getId());
		return "redirect:/posts/{postId}";

	}

	@ResponseBody
	@GetMapping("/images/{filename}")
	public Resource showImage(@PathVariable String filename) throws MalformedURLException {
		return new UrlResource("file:" + postImageFileStore.getFullPath(filename));
	}


	@GetMapping("/{postId}")
	public String getPostView(@PathVariable Long postId, Model model) {
		DetailPostResponse postResponse = postService.findPostOne(postId).convertPostToDetailPostResponse();
		model.addAttribute("postResponse", postResponse);
		return "posts/post-view";
	}


}
