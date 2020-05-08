package xiongjunmiao.top.Website.uitl.webtokenFilter.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xiongjunmiao.top.Website.uitl.webtokenFilter.mapper.UserMapper;
import xiongjunmiao.top.Website.uitl.webtokenFilter.service.UserService;
import xiongjunmiao.top.Website.uitl.webtokenFilter.userdomain.AppUser;

/**
 * Created by J on 2020/5/8 11:40
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public AppUser checkToken(String token){

        return new AppUser();
    }


}
