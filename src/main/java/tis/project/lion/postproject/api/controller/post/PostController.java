package tis.project.lion.postproject.api.controller.post;

import tis.project.lion.postproject.api.controller.ApiResult;


public interface PostController {

    ApiResult<DetailPostResponse> getPostOne(Long post_id);

    ApiResult<DetailPostResponse> createPost(PostRequest postRequest);

    ApiResult<DetailPostResponse> editPost(Long post_id, DetailPostResponse postDto);

    ApiResult<String> deletePost(Long post_id);
}
