package xiongjunmiao.top.Website.service;

import org.springframework.security.core.userdetails.UserDetails;
import xiongjunmiao.top.Website.domain.User;

/**
 * Created by J on 2020/5/21 9:28
 */
public interface IAdminService {

    /**
     * 获取用户信息
     */
    UserDetails loadUserByUsername(String username);

}
