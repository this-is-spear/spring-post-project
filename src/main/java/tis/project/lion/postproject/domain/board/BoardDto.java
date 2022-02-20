package tis.project.lion.postproject.domain.board;

public class BoardDto {

//    private static Long id;

    private String name;

    public BoardDto() {}

    public BoardDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Board convertBoard() {
        return new Board(this.name);
    }
}
