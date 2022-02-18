package tis.project.lion.postproject.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tis.project.lion.postproject.domain.Board;
import tis.project.lion.postproject.domain.BoardDto;
import tis.project.lion.postproject.service.BoardService;
import tis.project.lion.postproject.api.message.ResponseMessage;

@Slf4j
@RestController
@RequestMapping("/boards")
public class BoardControllerImpl implements BoardController{

    BoardService boardService;

    @Autowired
    public BoardControllerImpl(BoardService boardService) {
        this.boardService = boardService;
    }

    @Override
    @GetMapping("/{board_id}")
    public ResponseMessage getBoardOne(@PathVariable Long board_id) {
        Board findBoard = boardService.findBoardOne(board_id);
        log.debug("call {} {}",getClass().getName(), board_id);
        ResponseMessage message = new ResponseMessage(true, "OK"+ findBoard.getName());
        return message;
    }

    @Override
    @PostMapping
    public ResponseMessage createBoard(@RequestBody BoardDto boardDto) {

        log.debug("call {} {} {}",getClass().getName(), boardDto, boardDto.getName());
        boardService.createBoard(boardDto.convertBoard());
        ResponseMessage message = new ResponseMessage(true, "OK");
        return message;
    }

    @Override
    @PatchMapping("/{board_id}")
    public ResponseMessage editBoard(@PathVariable Long board_id, @RequestBody BoardDto boardDto) {
        BoardDto editBoardDto = new BoardDto(board_id, boardDto.getName());
        log.debug("call {} {} {}",getClass().getName(), boardDto.getName(), board_id);
        boardService.editBoard(editBoardDto.convertBoard());
        ResponseMessage message = new ResponseMessage(true, "OK");

        return message;
    }

    @Override
    @DeleteMapping("/{board_id}")
    public ResponseMessage deleteBoard(@PathVariable Long board_id) {
        log.debug("call {} {}",getClass().getName(), board_id);
        boardService.deleteBoard(board_id);
        ResponseMessage message = new ResponseMessage(true, "OK");
        return message;
    }
}
