package tis.project.lion.postproject.service;

import tis.project.lion.postproject.domain.post.Post;

public interface PostService {
    //post CRUD;

    Post createPost(Post post);

    Post findPostOne(Long post_id);

    Post editPost(Long post_id, Post postDto);

    void deletePost(Long post_id);
}
