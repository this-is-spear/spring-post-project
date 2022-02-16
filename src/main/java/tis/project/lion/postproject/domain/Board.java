package tis.project.lion.postproject.domain;

import javax.persistence.*;

@Entity
public class Board {
    @Id
    @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    private String name;
}
