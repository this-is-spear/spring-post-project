package tis.project.lion.postproject.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tis.project.lion.postproject.domain.board.Board;
import tis.project.lion.postproject.exception.DeleteException;
import tis.project.lion.postproject.exception.NoBoardException;
import tis.project.lion.postproject.repository.BoardRepository;

import java.util.Optional;

@Slf4j
@Service
@Transactional
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public Board createBoard(Board board) {
        return boardRepository.save(board);
    }

    @Override
    @Transactional(readOnly = true)
    public Board findBoardOne(Long board_id) {
        Optional<Board> findBoard = boardRepository.findById(board_id);
        if (findBoard.isEmpty()) {
            throw new NoBoardException("게시판이 존재하지 않습니다.");
        }
        return findBoard.get();
    }

    @Override
    public Board editBoard(Long board_id, Board board) {
        boardRepository.updateTitle(board_id, board.getName());
        return board;
    }

    @Override
    public void deleteBoard(Long board_id) {
        try {
            boardRepository.deleteById(board_id);
        } catch (EmptyResultDataAccessException e) {
            log.debug("[{}][{}][{}]", this.getClass().getName(), e.getMessage(), "no data");
            throw new DeleteException("해당 아이디에 존재하는 데이터가 없습니다.");
        }
    }
}
