package tis.project.lion.postproject.service;

import tis.project.lion.postproject.domain.Post;
import tis.project.lion.postproject.domain.PostRequest;

import java.util.List;

public interface PostService {
    //post CRUD;

    void createPost(PostRequest postDto);

    List<Post> findPostList();

    Post findPostOne(PostRequest postDto);

    void editPost(PostRequest postDto);

    void deletePost(PostRequest postDto);
}
