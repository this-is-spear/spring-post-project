package tis.project.lion.postproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import tis.project.lion.postproject.domain.post.Post;

import java.util.List;
import java.util.Optional;

public interface JpaPostRepository extends JpaRepository<Post, Long>, PostRepository {
    @Override
    <S extends Post> S save(S entity);

    @Override
    @Query("select p from Post p where p.board.id=:id")
    List<Post> findByBoardId(Long id);

    @Override
    @Modifying
    @Query("delete from Post p where p.id=:id")
    void deleteById(Long id);

    @Override
    Optional<Post> findById(Long aLong);
}
