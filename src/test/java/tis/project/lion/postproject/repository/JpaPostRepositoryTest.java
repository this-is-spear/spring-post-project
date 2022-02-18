package tis.project.lion.postproject.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import tis.project.lion.postproject.domain.Board;
import tis.project.lion.postproject.domain.Post;

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
        Post post = new Post(board, "title", "tis", "content", "password");
        postRepository.save(post);
    }

    @Test
    void edit() {
        Post post = new Post(board, "title", "tis", "content", "password");
        postRepository.save(post);
        postRepository.updateTitleAndContent(post.getId(), "edit", "editContent");
    }

    @Test
    void findOne() {
        Post post = new Post(board, "title", "tis", "content", "password");
        postRepository.save(post);
        Optional<Post> findPost = postRepository.findById(post.getId());
        System.out.println("findPost = " + findPost.get().getId());
    }

    @Test
    void findList() {
        for (int i = 0; i < 50; i++) {
            Post post = new Post(board, "title"+i, "tis", "content", "password");
            postRepository.save(post);
        }
        List<Post> postList = postRepository.findByBoardId(board.getId());
        for (Post post : postList) {
            System.out.println("post = " + post.getTitle());
        }
    }

    @Test
    void delete() {
        Post post = new Post(board, "title", "tis", "content", "password");
        Post savePost = postRepository.save(post);
        System.out.println("savePost = " + savePost.getId());

        postRepository.deleteById(post.getId());
        //???? 영속성 컨텍스트에서는 저장이 되어있네??? 지져스
        System.out.println("savePost = " + savePost.getId());
    }
}