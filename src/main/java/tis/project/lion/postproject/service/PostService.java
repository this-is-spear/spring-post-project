package tis.project.lion.postproject.service;

import tis.project.lion.postproject.domain.Board;
import tis.project.lion.postproject.domain.BoardDto;
import tis.project.lion.postproject.domain.Post;
import tis.project.lion.postproject.domain.PostDto;

import java.util.List;

public interface PostService {
    //board CRUD;
    public void createBoard(BoardDto boardDto);

    public Board findBoardOne(BoardDto boardDto);

    public Board updateBoard(BoardDto boardDto);

    public void deleteBoard(BoardDto boardDto);
    //post CRUD;

    public void createPost(PostDto postDto);

    public List<Post> findPostList();

    public Post findPostOne(PostDto postDto);

    public Post updatePost(PostDto postDto);

    public void deletePost(PostDto postDto);
}
