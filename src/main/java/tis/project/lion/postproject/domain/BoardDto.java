package tis.project.lion.postproject.domain;

public class BoardDto {

    private Long id;
    private String name;

    public BoardDto(Long id) {
        this.id = id;
    }

    public BoardDto(String name) {
        this.name = name;
    }

    public BoardDto() {
    }

    public BoardDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Board convertBoard() {
        return new Board(this.id, this.name);
    }
}
