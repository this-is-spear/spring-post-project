package tis.project.lion.postproject.service;

import tis.project.lion.postproject.domain.Board;
import tis.project.lion.postproject.exception.DeleteException;

public interface BoardService {
    //board CRUD;

    Board createBoard(Board board);

    Board findBoardOne(Long id);

    Board editBoard(Board board);

    void deleteBoard(Long id) throws DeleteException;
}
