package xiongjunmiao.top.Website.domain;

/**
 * 权限表
 */
public class AdminResource {

    private String name;
    private Long id;

    public AdminResource(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public AdminResource() {
    }

    @Override
    public String toString() {
        return "AdminResource{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
