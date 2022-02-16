package tis.project.lion.postproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tis.project.lion.postproject.domain.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    public void save(Post post);

    public List<Post> findByBoardId(Long id);

    public Optional<Post> findById(Long id);

    public void delete(Post post);
}
