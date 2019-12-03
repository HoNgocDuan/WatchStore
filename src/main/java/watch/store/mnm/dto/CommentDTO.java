package watch.store.mnm.dto;

import java.util.Date;

public class CommentDTO {

    private int id;
    private String content;
    private Date createDate;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CommentDTO(String content) {
        this.content = content;
    }

    public CommentDTO() {
    }
}
