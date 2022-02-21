package tis.project.lion.postproject.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tis.project.lion.postproject.domain.post.Post;
import tis.project.lion.postproject.exception.NoPostException;
import tis.project.lion.postproject.repository.PostRepository;

import java.util.Optional;

@Service
@Transactional
public class PostServiceImpl implements PostService{

	private final PostRepository postRepository;

	public PostServiceImpl(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@Override
	public Post createPost(Post post) {
		return postRepository.save(post);
	}

	@Override
	@Transactional(readOnly = true)
	public Post findPostOne(Long post_id) {
		Optional<Post> findPost = postRepository.findById(post_id);
		if (findPost.isEmpty()) {
			throw new NoPostException("게시글이 존재하지 않습니다.");
		}
		return findPost.get();
	}

	@Override
	public Post editPost(Long post_id, Post post) {
		postRepository.updateTitleAndContent(post_id, post.getTitle(), post.getContent());
		return post;
	}

	@Override
	public void deletePost(Long post_id) {
		postRepository.deleteById(post_id);
	}
}
