package tis.project.lion.postproject.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;
import tis.project.lion.postproject.domain.Board;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@TestPropertySource(locations = "classpath:application.yml")
@Transactional
class BoardRepositoryImplTest {

    @Autowired
    BoardRepository boardRepository;

    Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
        board.setName("asdf");
        boardRepository.save(board);
    }

    @Test
    @DisplayName("저장 테스트")
    void 저장() {
        Board board = new Board();
        board.setName("asdf");
        boardRepository.save(board);
        assertEquals(board.getId(), boardRepository.findById(board.getId()).get().getId());
    }

    @Test
    void 삭제() {
        assertDoesNotThrow(() -> {
            boardRepository.deleteById(board.getId());
        });
    }

    @Test
    void 조회() {
        Long id = board.getId();
        assertEquals(id, boardRepository.findById(id).get().getId());
    }

    @Test
    void 수정() {
        Long id = board.getId();
        String name = "aaa";
        Board findBord = boardRepository.findById(id).get();
        findBord.setName(name);
        boardRepository.save(findBord);
        assertEquals(board.getName(), name);
        assertEquals(findBord.getName(), name);
    }
}