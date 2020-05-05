package xiongjunmiao.top.Website.domain;

/**
 * @Description TODO
 * @Author dangran
 * @Date 2020/4/15 10:22
 * @Version v1.0
 */

public class Comment {

    private Long id;
    private String content;
    private Long parentId;
    private Long subscriberId;

    public Comment() {
    }

    public Comment(Long id, String content, Long parentId, Long subscriberId) {
        this.id = id;
        this.content = content;
        this.parentId = parentId;
        this.subscriberId = subscriberId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(Long subscriberId) {
        this.subscriberId = subscriberId;
    }

    @Override
    public String toString() {
        return "comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", parentId=" + parentId +
                ", subscriberId=" + subscriberId +
                '}';
    }
}
