package xiongjunmiao.top.Website.domain;

/**
 * @Description TODO
 * @Author dangran
 * @Date 2020/4/15 10:21
 * @Version v1.0
 */
public class Subscriber {
    private Long id;
    private String username;
    private String head;
    private Integer sex;

    public Subscriber() {
    }

    public Subscriber(Long id, String username, String head, Integer sex) {
        this.id = id;
        this.username = username;
        this.head = head;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "subscriber{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", head='" + head + '\'' +
                ", sex=" + sex +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
