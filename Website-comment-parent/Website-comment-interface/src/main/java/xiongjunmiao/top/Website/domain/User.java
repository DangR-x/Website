package xiongjunmiao.top.Website.domain;

/**
 * Created by J on 2020/5/14 16:09
 */
public class User {

    private Long id;
    private String username;
    private String password;
    private Integer role;
    private String menu;

    public User() {
    }

    public User(Long id, String username, String password, Integer role, String menu) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.menu = menu;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", menu='" + menu + '\'' +
                '}';
    }
}
