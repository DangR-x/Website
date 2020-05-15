package xiongjunmiao.top.Website.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xiongjunmiao.top.Website.domain.AppUser;
import xiongjunmiao.top.Website.mapper.AppUserMapper;
import xiongjunmiao.top.Website.repeat.util.Convert;
import xiongjunmiao.top.Website.service.IAppUserService;


/**
 * Created by J on 2020/5/8 11:40
 */
@Service
public class AppUserServiceImpl implements IAppUserService {

    @Autowired
    private AppUserMapper appUserMapper;

    public AppUser checkToken(String token){

        return new AppUser();
    }

    @Override
    public AppUser findByUsername(String username) {
        return appUserMapper.findByUsername(username);
    }


}
