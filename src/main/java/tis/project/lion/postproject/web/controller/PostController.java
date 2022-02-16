package tis.project.lion.postproject.web.controller;

import tis.project.lion.postproject.web.form.InputPostForm;
import tis.project.lion.postproject.web.message.ResponseMessage;

public interface PostController {
    //리스트는 board id가 필요
//    public String getPostListForm(Long board_id);
    public ResponseMessage getPostList(Long board_id);

//    public String getPostOneForm(Long post_id);

    public ResponseMessage getPostOne(Long post_id);

    //board id는 어떻게 넘겨줘야 하지?
//    public String createPostForm(Long board_id);

    public ResponseMessage createPost(InputPostForm postForm);

//    public String updatePostForm();

    public ResponseMessage editPost(InputPostForm postForm);

    public ResponseMessage deletePost(Long post_id);
}
