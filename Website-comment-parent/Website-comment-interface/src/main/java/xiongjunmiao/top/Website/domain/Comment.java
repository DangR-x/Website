package xiongjunmiao.top.Website.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * @Description TODO
 * @Author dangran
 * @Date 2020/4/15 10:22
 * @Version v1.0
 */

public class Comment {


    /**
     * 用于controller接收参数的验证:BindingResult
     * @NotEmpty(message="id不能为空")
     * @Min(value = 18, message = "年龄必须大于18岁")
     * @NotEmpty(message="hobbies不能为空")
     * @NotBlank(message="账号不能为空")
     * @Size(min=5,max=10,message="密码的长度应该在5和10之间")
     * @Email(message="邮箱格式错误")
     */
    @Min(value = 18, message = "年龄必须大于18岁")
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
