package tis.project.lion.postproject.api.controller.post;

import tis.project.lion.postproject.api.controller.ApiResult;


public interface PostController {

    ApiResult<PostDto> getPostOne(Long post_id);

    ApiResult<PostDto> createPost(PostRequest postRequest);

    ApiResult<PostDto> editPost(Long post_id, PostDto postDto);

    ApiResult<String> deletePost(Long post_id);
}
