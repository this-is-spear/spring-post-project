package tis.project.lion.postproject.web;

public interface PostController {
    //리스트는 board id가 필요
    public String getPostListForm(Long board_id);

    public String getPostOneForm(Long post_id);

//    public OutputPostForm getPostOne(Long post_id);

    //board id는 어떻게 넘겨줘야 하지?
    public String createPostForm(Long board_id);

    public String createPost(InputPostForm postForm);

    public String updatePostForm();

    public String updatePOst(InputPostForm postForm);

    public String deletePost(Long post_id);
}
