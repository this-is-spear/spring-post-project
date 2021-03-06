package tis.project.lion.postproject.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import tis.project.lion.postproject.domain.board.Board;
import tis.project.lion.postproject.domain.post.Post;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback(value = false)
class JpaPostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Autowired
    BoardRepository boardRepository;

    Board board;

    @BeforeEach
    void setUp() {
        board = new Board("test1");
        boardRepository.save(board);
    }

    @Test
    void save() {
        Post post = new Post(null, board, "title", "tis", "content", "password");
        postRepository.save(post);
    }

    @Test
    void edit() {
        Post post = new Post(null, board, "title", "tis", "content", "password");
        postRepository.save(post);
        post.setWriter("edit");
        post.setContent("editContent");
        postRepository.save(post);
    }

    @Test
    void findOne() {
        Post post = new Post(null, board, "title", "tis", "content", "password");
        postRepository.save(post);
        Optional<Post> findPost = postRepository.findById(post.getId());
        System.out.println("findPost = " + findPost.get().getId());
    }

    @Test
    void findList() {
        for (int i = 0; i < 50; i++) {
            Post post = new Post(null, board, "title"+i, "tis", "content", "password");
            postRepository.save(post);
        }
        List<Post> postList = postRepository.findByBoardId(board.getId());
        for (Post post : postList) {
            System.out.println("post = " + post.getTitle());
        }
    }

    @Test
    void delete() {
        Post post = new Post(null, board, "title", "tis", "content", "password");
        Post savePost = postRepository.save(post);
        System.out.println("savePost = " + savePost.getId());

        postRepository.deleteById(post.getId());
        //???? ????????? ????????????????????? ????????? ??????????????? ?????????
        System.out.println("savePost = " + savePost.getId());
    }
}