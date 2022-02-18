package tis.project.lion.postproject.api.controller;

import tis.project.lion.postproject.domain.BoardDto;
import tis.project.lion.postproject.api.message.ResponseMessage;

public interface BoardController {
//    public String getBoardListForm();
    ResponseMessage getBoardOne(Long board_id);
//    public String createForm();
    ResponseMessage createBoard(BoardDto boardDto);
//    public String updateForm(Long board_id);
    ResponseMessage editBoard(Long board_id, BoardDto boardDto);

    ResponseMessage deleteBoard(Long board_id);
}
