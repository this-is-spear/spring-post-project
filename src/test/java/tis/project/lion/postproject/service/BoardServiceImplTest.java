package tis.project.lion.postproject.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tis.project.lion.postproject.domain.board.Board;
import tis.project.lion.postproject.repository.BoardRepository;

//@ExtendWith(MockitoExtension.class)
@SpringBootTest
class BoardServiceImplTest {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    BoardService boardService;

    @Test
    @DisplayName("저장 테스트")
    void 저장() {
        Board board = new Board("name");
        boardService.createBoard(board);
    }

    @Test
    @DisplayName("삭제 테스트")
    void 삭제() {
        Board board = new Board("name");
        boardService.createBoard(board);
    }

    @Test
    @DisplayName("조회 테스트")
    void 조회() {
    }

    @Test
    @DisplayName("수정 테스트")
    void 수정() {
    }
}