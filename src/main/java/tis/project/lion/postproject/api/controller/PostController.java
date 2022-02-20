package tis.project.lion.postproject.api.controller;

import tis.project.lion.postproject.api.message.ResponseMessage;
import tis.project.lion.postproject.domain.post.PostRequest;

public interface PostController {
    //리스트는 board id가 필요
//    public String getPostListForm(Long board_id);
    ResponseMessage getPostList(Long board_id);

//    public String getPostOneForm(Long post_id);

    ResponseMessage getPostOne(Long post_id);

    //board id는 어떻게 넘겨줘야 하지?
//    public String createPostForm(Long board_id);

    ResponseMessage createPost(PostRequest postDto);

//    public String updatePostForm();

    ResponseMessage editPost(Long post_id, PostRequest postDto);

    ResponseMessage deletePost(Long post_id);
}
