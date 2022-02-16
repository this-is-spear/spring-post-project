package tis.project.lion.postproject.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tis.project.lion.postproject.domain.Board;

import javax.persistence.EntityManager;

@Repository
public class BoardRepositoryImpl implements BoardRepository {
    private EntityManager em;

    @Autowired
    public BoardRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Board board) {
        em.persist(board);
    }

    @Override
    public Board findById(Long id) {
        return em.find(Board.class, id);
    }

    @Override
    public void delete(Board board) {
//        em.createQuery("delete from board where board_id = :id");
        em.remove(board);
    }
}
