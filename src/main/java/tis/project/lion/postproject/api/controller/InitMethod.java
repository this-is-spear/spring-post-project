package tis.project.lion.postproject.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.InitBinder;
import tis.project.lion.postproject.domain.board.Board;
import tis.project.lion.postproject.domain.post.Post;
import tis.project.lion.postproject.service.BoardService;
import tis.project.lion.postproject.service.PostService;

import javax.annotation.PostConstruct;

@Component
public class InitMethod {
	private final BoardService boardService;
	private final PostService postService;

	public InitMethod(BoardService boardService, PostService postService) {
		this.boardService = boardService;
		this.postService = postService;
	}

	@PostConstruct
	public void createTestBoard() {
		Board board1 = new Board(null, "test name");
		boardService.createBoard(board1);
		Board board2 = new Board(null, "test name");
		boardService.createBoard(board2);
		Board board3 = new Board(null, "test name");
		boardService.createBoard(board3);
		for (int i = 0; i < 200; i++) {
			Post post = new Post(null, board1, "test "+ i, "test", "content " + i, "password");
			postService.createPost(post);
		}
	}
}
