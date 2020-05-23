package xiongjunmiao.top.Website.dto;

import javax.validation.constraints.NotEmpty;

/**
 * Created by J on 2020/5/22 11:31
 */
public class LoginAdminParam {
    @NotEmpty(message = "用户名不能为空")
    private String name;
    @NotEmpty(message = "用户名不能为空")
    private String password;

    public LoginAdminParam(@NotEmpty(message = "用户名不能为空") String name, @NotEmpty(message = "用户名不能为空") String password) {
        this.name = name;
        this.password = password;
    }

    public LoginAdminParam() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginAdminParam{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
