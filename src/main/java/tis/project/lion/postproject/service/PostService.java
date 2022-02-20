package tis.project.lion.postproject.service;

import tis.project.lion.postproject.domain.post.Post;

import java.util.List;

public interface PostService {
    //post CRUD;

    Post createPost(Post post);

    List<Post> findPostList(Long board_id);

    Post findPostOne(Long post_id);

    Post editPost(Long post_id, Post postDto);

    void deletePost(Long post_id);
}
