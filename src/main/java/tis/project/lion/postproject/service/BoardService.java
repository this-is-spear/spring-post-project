package tis.project.lion.postproject.service;

import tis.project.lion.postproject.domain.Board;
import tis.project.lion.postproject.domain.BoardDto;

public interface BoardService {
    //board CRUD;

    public void createBoard(BoardDto boardDto);

    public Board findBoardOne(BoardDto boardDto);

    public void editBoard(BoardDto boardDto);

    public void deleteBoard(BoardDto boardDto);
}
