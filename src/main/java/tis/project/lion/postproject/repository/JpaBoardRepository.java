package tis.project.lion.postproject.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tis.project.lion.postproject.domain.Board;

import java.util.Optional;

@Primary
@Repository
public interface JpaBoardRepository extends JpaRepository<Board, Long>, BoardRepository {
    @Override
    <S extends Board> S save(S entity);

    @Override
    Optional<Board> findById(Long aLong);

    @Override
    void deleteById(Long id);

    @Override
    @Modifying
    @Query("UPDATE Board p SET p.name = :name WHERE p.id = :id")
    void updateTitle(Long id, String name);
}
