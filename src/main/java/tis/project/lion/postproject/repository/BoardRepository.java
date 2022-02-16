package tis.project.lion.postproject.repository;

import tis.project.lion.postproject.domain.Board;

public interface BoardRepository {
    public void save(Board board);

    public Board findById(Long id);

    public void delete(Board board);
}
