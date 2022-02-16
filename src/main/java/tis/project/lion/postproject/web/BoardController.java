package tis.project.lion.postproject.web;

import tis.project.lion.postproject.web.message.ResponseMessage;

public interface BoardController {
//    public String getBoardListForm();
    public ResponseMessage getBoardOne(Long board_id);
//    public String createForm();
    public ResponseMessage createBoard(InputBoardForm boardForm);
//    public String updateForm(Long board_id);
    public ResponseMessage updateBoard(InputBoardForm boardForm);
    public ResponseMessage deleteBoard(Long board_id);
}
