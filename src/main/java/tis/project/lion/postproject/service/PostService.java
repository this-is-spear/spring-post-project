package tis.project.lion.postproject.service;

import tis.project.lion.postproject.domain.Post;
import tis.project.lion.postproject.domain.PostDto;

import java.util.List;

public interface PostService {
    //post CRUD;

    void createPost(PostDto postDto);

    List<Post> findPostList();

    Post findPostOne(PostDto postDto);

    void editPost(PostDto postDto);

    void deletePost(PostDto postDto);
}
