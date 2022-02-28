package tis.project.lion.postproject.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tis.project.lion.postproject.domain.post.Post;
import tis.project.lion.postproject.exception.NoPostException;
import tis.project.lion.postproject.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService{

	private final PostRepository postRepository;

	public PostServiceImpl(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@Override
	@Transactional
	public Post createPost(Post post) {
		return postRepository.save(post);
	}

	@Override
	@Transactional(readOnly = true)
	public Post findPostOne(Long post_id) {
		return postRepository.findById(post_id).orElseThrow(NoPostException::new);
	}

	@Override
	@Transactional
	public Post editPost(Long post_id, Post post) {
		Post findPost = findPostOne(post_id);
		if (post.getTitle() != null) {
			findPost.setTitle(post.getTitle());
		}
		if (post.getContent() != null) {
			findPost.setContent(post.getContent());
		}
//		if (!post.getImagesFiles().isEmpty()) {
//			findPost.setImagesFiles(post.getImagesFiles());
//		}
		if (post.getWriter() != null) {
			findPost.setWriter(post.getWriter());
		}
		if (post.getPassword() != null) {
			findPost.setPassword(post.getPassword());
		}
		return postRepository.save(findPost);
	}

	@Override
	@Transactional
	public void deletePost(Long post_id) {
		postRepository.deleteById(post_id);
	}
}
