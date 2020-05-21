package xiongjunmiao.top.Website.service;


import org.springframework.security.core.userdetails.UserDetails;
import xiongjunmiao.top.Website.domain.User;

import java.io.Serializable;
import java.util.List;

/**
 * Created by J on 2020/5/8 11:39
 */
public interface IUserService {
    void insert(User t);
    //Serializable是Long，string等等的顶级接口
    void deleteById(Serializable id);
    void updateById(User t);
    User selectById(Serializable id);
    List<User> selectAll();
    /**
     * 获取用户信息
     */
    UserDetails loadUserByUsername(String username);

}
