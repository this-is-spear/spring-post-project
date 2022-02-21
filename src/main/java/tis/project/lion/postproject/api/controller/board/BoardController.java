package tis.project.lion.postproject.api.controller.board;

import tis.project.lion.postproject.api.controller.ApiResult;
import tis.project.lion.postproject.exception.DeleteException;

public interface BoardController {

    ApiResult<BoardResponse> getBoardOne(Long board_id);

    ApiResult<BoardResponse> createBoard(BoardResponse boardDto);

    ApiResult<BoardResponse> editBoard(Long board_id, BoardResponse boardDto);

    ApiResult<String> deleteBoard(Long board_id) throws DeleteException;
}
