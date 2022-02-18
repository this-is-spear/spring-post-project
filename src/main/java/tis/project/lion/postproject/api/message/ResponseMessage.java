package tis.project.lion.postproject.api.message;

public class ResponseMessage {
    private boolean isSuccess;
    private String messageContent;

    public ResponseMessage(boolean isSuccess, String messageContent) {
        this.isSuccess = isSuccess;
        this.messageContent = messageContent;
    }

    public ResponseMessage() {
    }

    public ResponseMessage success() {
        this.isSuccess = true;
        this.messageContent = "성공";
        return this;
    }

    public ResponseMessage fail() {
        this.isSuccess = false;
        this.messageContent = "실패";
        return this;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public String getMessageContent() {
        return messageContent;
    }
}
