package tis.project.lion.postproject.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tis.project.lion.postproject.domain.ApiResult;
import tis.project.lion.postproject.domain.board.Board;
import tis.project.lion.postproject.domain.board.BoardDto;
import tis.project.lion.postproject.domain.post.Post;
import tis.project.lion.postproject.domain.post.PostDto;
import tis.project.lion.postproject.exception.DeleteException;
import tis.project.lion.postproject.service.BoardService;

import java.util.List;
import java.util.stream.Collectors;

import static tis.project.lion.postproject.domain.ApiResult.*;

@Slf4j
@RestController
@RequestMapping("/boards")
public class BoardControllerImpl implements BoardController{

    private final BoardService boardService;

    @Autowired
    public BoardControllerImpl(BoardService boardService) {
        this.boardService = boardService;
    }

    @Override
    @GetMapping("/{board_id}")
    public ApiResult<BoardDto> getBoardOne(@PathVariable Long board_id) {
        log.debug("call {} {}",getClass().getName(), board_id);
        Board board = boardService.findBoardOne(board_id);
        return OK(getBoardDto(board));
    }

    @Override
    @PostMapping
    public ApiResult<BoardDto> createBoard(@RequestBody BoardDto boardDto) {
        log.debug("call {} {} {}",getClass().getName(), boardDto, boardDto.getName());
        Board board = boardService.createBoard(boardDto.convertBoard());
        return OK(getBoardDto(board));
    }



    @Override
    @PatchMapping("/{board_id}")
    public ApiResult<BoardDto> editBoard(@PathVariable Long board_id, @RequestBody BoardDto boardDto) {
        log.debug("call {} {} {}",getClass().getName(), boardDto.getName(), board_id);
        Board board = boardService.editBoard(board_id, boardDto.convertBoard());
        return OK(getBoardDto(board));
    }

    @Override
    @DeleteMapping("/{board_id}")
    public ApiResult<String> deleteBoard(@PathVariable Long board_id) throws DeleteException {
        log.debug("call {} {}",getClass().getName(), board_id);
        boardService.deleteBoard(board_id);
        return OK("delete OK");
    }

    private List<PostDto> getPostDtoList(List<Post> postList) {
        return postList.stream().map(Post::convertPostDto).collect(Collectors.toList());
    }

    private BoardDto getBoardDto(Board board) {
        return new BoardDto(board.getName(), getPostDtoList(board.getPostList()));
    }
}
