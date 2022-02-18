package tis.project.lion.postproject.repository;

import tis.project.lion.postproject.domain.Board;

import java.util.Optional;

public interface BoardRepository {
    <S extends Board> S save(S entity);

    Optional<Board> findById(Long aLong);

    void deleteById(Long id);

    void updateTitle(Long id, String name);
}
