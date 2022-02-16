package tis.project.lion.postproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tis.project.lion.postproject.domain.Board;
import tis.project.lion.postproject.domain.BoardDto;
import tis.project.lion.postproject.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService{

//    @Autowired
//    BoardRepository boardRepository;

    @Override
    public void createBoard(BoardDto boardDto) {

    }

    @Override
    public Board findBoardOne(BoardDto boardDto) {
        return null;
    }

    @Override
    public void editBoard(BoardDto boardDto) {
    }

    @Override
    public void deleteBoard(BoardDto boardDto) {

    }
}
