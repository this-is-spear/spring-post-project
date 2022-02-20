package tis.project.lion.postproject.domain.board;

public class BoardResponse {

//    private static Long id;

    private final String name;

    public BoardResponse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Board convertBoard() {
        return new Board(this.name);
    }
}
