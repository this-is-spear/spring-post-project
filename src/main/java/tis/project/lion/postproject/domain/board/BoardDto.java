package tis.project.lion.postproject.domain.board;

import tis.project.lion.postproject.domain.post.PostDto;

import java.util.List;
public class BoardDto {

//    private static Long id;

    private String name;

    private List<PostDto> postList;

    public BoardDto() {}

    public BoardDto(String name) {
        this.name = name;
    }

    public BoardDto(String name, List<PostDto> postList) {
        this.name = name;
        this.postList = postList;
    }

    public String getName() {
        return name;
    }

    public List<PostDto> getPostList() {
        return postList;
    }

    public Board convertBoard() {
        return new Board(this.name);
    }

}
