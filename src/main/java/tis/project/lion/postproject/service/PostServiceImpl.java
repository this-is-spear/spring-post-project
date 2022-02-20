package tis.project.lion.postproject.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tis.project.lion.postproject.domain.post.Post;
import tis.project.lion.postproject.repository.BoardRepository;
import tis.project.lion.postproject.repository.PostRepository;

import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService{

	private final BoardRepository boardRepository;
	private final PostRepository postRepository;

	public PostServiceImpl(BoardRepository boardRepository, PostRepository postRepository) {
		this.boardRepository = boardRepository;
		this.postRepository = postRepository;
	}

	@Override
	public Post createPost(Post post) {
		return postRepository.save(post);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Post> findPostList(Long board_id) {
		return postRepository.findByBoardId(board_id);
	}

	@Override
	@Transactional(readOnly = true)
	public Post findPostOne(Long post_id) {
		return postRepository.findById(post_id).get();
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
