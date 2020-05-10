package xiongjunmiao.top.Website.domain;

import lombok.Data;

/**
 * @author qiaomengnan
 * @ClassName: BaseUser
 * @Description: user基类
 * @date 2018/1/7
 */
@Data
public class BaseUser<T> extends BaseEntity<T> {

    /**
     * @Fields  : 用户ID
     */
    private String userId;

    /**
     * @Fields  : 用户登录名称
     */
    private String userName;

    /**
     * @Fields  : 用户名称
     */
    private String userNameFull;

    /**
     * @Fields  : 用户密码
     */
    private String userPassword;

    /**
     * @Fields  : 所属用户组
     * @author qiaomengnan
     */
    private String groupCode;

}
