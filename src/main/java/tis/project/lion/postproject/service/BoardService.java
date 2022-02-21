package tis.project.lion.postproject.service;

import tis.project.lion.postproject.domain.board.Board;
import tis.project.lion.postproject.exception.DeleteException;

public interface BoardService {
    //board CRUD;

    Board createBoard(Board board);

    Board findBoardOne(Long board_id);

    Board editBoard(Long board_id, Board board);

    void deleteBoard(Long board_id) throws DeleteException;
}
