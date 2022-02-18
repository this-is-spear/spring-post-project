package tis.project.lion.postproject.api.controller;

import tis.project.lion.postproject.domain.BoardResponse;
import tis.project.lion.postproject.api.message.ResponseMessage;
import tis.project.lion.postproject.exception.DeleteException;

public interface BoardController {
//    public String getBoardListForm();
    ResponseMessage getBoardOne(Long board_id);
//    public String createForm();
    ResponseMessage createBoard(BoardResponse boardDto);
//    public String updateForm(Long board_id);
    ResponseMessage editBoard(Long board_id, BoardResponse boardDto);

    ResponseMessage deleteBoard(Long board_id) throws DeleteException;
}
