package tis.project.lion.postproject.service;

import tis.project.lion.postproject.domain.Board;
import tis.project.lion.postproject.domain.BoardDto;
import tis.project.lion.postproject.domain.Post;
import tis.project.lion.postproject.domain.PostDto;

import java.util.List;

public interface PostService {
    //post CRUD;

    public void createPost(PostDto postDto);

    public List<Post> findPostList();

    public Post findPostOne(PostDto postDto);

    public Post editPost(PostDto postDto);

    public void deletePost(PostDto postDto);
}
