package tis.project.lion.postproject.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tis.project.lion.postproject.domain.Board;
import tis.project.lion.postproject.exception.DeleteException;
import tis.project.lion.postproject.repository.JpaBoardRepository;

import java.util.Optional;

@Slf4j
@Service
@Transactional
public class BoardServiceImpl implements BoardService{

    JpaBoardRepository boardRepository;

    @Autowired
    public BoardServiceImpl(JpaBoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public Board createBoard(Board board) {
        return boardRepository.save(board);
    }

    @Override
    public Board findBoardOne(Long id) {
        Optional<Board> findBoard = boardRepository.findById(id);
        return findBoard.get();
    }

    @Override
    public Board editBoard(Board board) {
        boardRepository.updateTitle(board.getId(), board.getName());
        return boardRepository.findById(board.getId()).get();
    }

    @Override
    public void deleteBoard(Long id) throws DeleteException {
        try {
            boardRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            log.debug("[{}][{}][{}]", this.getClass().getName(), e.getMessage(), "no data");
            throw new DeleteException("해당 아이디에 존재하는 데이터가 없습니다.");
        }
    }
}
