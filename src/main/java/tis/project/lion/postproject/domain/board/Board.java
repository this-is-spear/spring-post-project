package tis.project.lion.postproject.domain.board;

import tis.project.lion.postproject.domain.post.Post;

import javax.persistence.*;
import java.util.List;

@Entity
public class Board {
    @Id
    @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "board")
    private List<Post> postList;

    public Board(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Board(String name, List<Post> postList) {
        this.name = name;
        this.postList = postList;
    }

    public Board() {
    }

    public Board(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public List<Post> getPostList() {
        return postList;
    }
}
