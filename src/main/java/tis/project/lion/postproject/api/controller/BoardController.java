package tis.project.lion.postproject.api.controller;

import tis.project.lion.postproject.domain.ApiResult;
import tis.project.lion.postproject.domain.board.BoardDto;
import tis.project.lion.postproject.exception.DeleteException;

public interface BoardController {
//    public String getBoardListForm();
    ApiResult<BoardDto> getBoardOne(Long board_id);
//    public String createForm();
    ApiResult<BoardDto> createBoard(BoardDto boardDto);
//    public String updateForm(Long board_id);
    ApiResult<BoardDto> editBoard(Long board_id, BoardDto boardDto);

    ApiResult<String> deleteBoard(Long board_id) throws DeleteException;
}
