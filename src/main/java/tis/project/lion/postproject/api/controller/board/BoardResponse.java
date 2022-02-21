package tis.project.lion.postproject.api.controller.board;

import tis.project.lion.postproject.api.controller.post.SimplePostResponse;
import tis.project.lion.postproject.domain.board.Board;
import tis.project.lion.postproject.api.controller.post.DetailPostResponse;

import java.util.List;
public class BoardResponse {

//    private static Long id;

    private String name;

    private List<SimplePostResponse> postList;

    public BoardResponse() {}

    public BoardResponse(String name) {
        this.name = name;
    }

    public BoardResponse(String name, List<SimplePostResponse> postList) {
        this.name = name;
        this.postList = postList;
    }

    public String getName() {
        return name;
    }

    public List<SimplePostResponse> getPostList() {
        return postList;
    }

    public Board convertBoard() {
        return new Board(this.name);
    }

}
