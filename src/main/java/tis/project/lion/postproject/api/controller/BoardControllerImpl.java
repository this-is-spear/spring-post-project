package tis.project.lion.postproject.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tis.project.lion.postproject.domain.ApiResult;
import tis.project.lion.postproject.domain.board.Board;
import tis.project.lion.postproject.domain.board.BoardDto;
import tis.project.lion.postproject.exception.DeleteException;
import tis.project.lion.postproject.service.BoardService;

import javax.annotation.PostConstruct;

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
        return ApiResult.OK(new BoardDto(board.getName()));
    }

    @Override
    @PostMapping
    public ApiResult<BoardDto> createBoard(@RequestBody BoardDto boardDto) {
        log.debug("call {} {} {}",getClass().getName(), boardDto, boardDto.getName());
        Board board = boardService.createBoard(boardDto.convertBoard());
        return ApiResult.OK(new BoardDto(board.getName()));
    }

    @Override
    @PatchMapping("/{board_id}")
    public ApiResult<BoardDto> editBoard(@PathVariable Long board_id, @RequestBody BoardDto boardDto) {
        log.debug("call {} {} {}",getClass().getName(), boardDto.getName(), board_id);
        Board board = boardService.editBoard(board_id, boardDto.convertBoard());
        return ApiResult.OK(new BoardDto(board.getName()));
    }

    @Override
    @DeleteMapping("/{board_id}")
    public ApiResult<String> deleteBoard(@PathVariable Long board_id) throws DeleteException {
        log.debug("call {} {}",getClass().getName(), board_id);
        boardService.deleteBoard(board_id);
        return ApiResult.OK("delete OK");
    }


}
