package tis.project.lion.postproject.api.controller;

import tis.project.lion.postproject.domain.ApiResult;
import tis.project.lion.postproject.domain.post.PostDto;
import tis.project.lion.postproject.domain.post.PostRequest;


public interface PostController {
    //리스트는 board id가 필요
//    public String getPostListForm(Long board_id);

//    public String getPostOneForm(Long post_id);

    ApiResult<PostDto> getPostOne(Long post_id);

    //board id는 어떻게 넘겨줘야 하지?
//    public String createPostForm(Long board_id);

    ApiResult<PostDto> createPost(PostRequest postRequest);

//    public String updatePostForm();

    ApiResult<PostDto> editPost(Long post_id, PostDto postDto);

    ApiResult<String> deletePost(Long post_id);
}
