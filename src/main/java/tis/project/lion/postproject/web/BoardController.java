package tis.project.lion.postproject.web;

public interface BoardController {
    public String getBoardList();
    public String getBoardOne(Long board_id);
    public String createForm();
    public String createBoard(InputBoardForm boardForm);
    public String updateForm(Long board_id);
    public String updateBoard(InputBoardForm boardForm);
    public String deleteBoard(Long board_id);
}
