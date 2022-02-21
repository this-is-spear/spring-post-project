package tis.project.lion.postproject.repository;

import tis.project.lion.postproject.domain.post.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    <S extends Post> S save(S entity);

    List<Post> findByBoardId(Long id);

    Optional<Post> findById(Long id);

    void deleteById(Long id);
}
