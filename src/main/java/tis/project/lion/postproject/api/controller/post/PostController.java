package tis.project.lion.postproject.api.controller.post;

import org.springframework.web.multipart.MultipartFile;
import tis.project.lion.postproject.api.controller.ApiResult;

import java.io.IOException;
import java.util.List;


public interface PostController {

    ApiResult<DetailPostResponse> getPostOne(Long postId);

    ApiResult<DetailPostResponse> createPost(PostRequest postRequest) throws IOException;

    ApiResult<DetailPostResponse> editPost(Long postId, DetailPostResponse postDto);

    ApiResult<String> deletePost(Long postId);
}
