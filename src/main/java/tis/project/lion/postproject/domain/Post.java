package tis.project.lion.postproject.domain;

import javax.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    private Long board_id;

    private String title;

    private String writer;

    private String Content;

    private String password;
}
