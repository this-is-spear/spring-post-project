package tis.project.lion.postproject.api.controller.board;

import tis.project.lion.postproject.api.controller.ApiResult;
import tis.project.lion.postproject.exception.DeleteException;

public interface BoardController {

    ApiResult<BoardDto> getBoardOne(Long board_id);

    ApiResult<BoardDto> createBoard(BoardDto boardDto);

    ApiResult<BoardDto> editBoard(Long board_id, BoardDto boardDto);

    ApiResult<String> deleteBoard(Long board_id) throws DeleteException;
}
