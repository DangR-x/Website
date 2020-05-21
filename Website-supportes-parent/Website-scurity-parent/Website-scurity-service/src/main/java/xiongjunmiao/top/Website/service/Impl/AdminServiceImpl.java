package xiongjunmiao.top.Website.service.Impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import xiongjunmiao.top.Website.domain.AsUserDetails;
import xiongjunmiao.top.Website.domain.User;
import xiongjunmiao.top.Website.service.IAdminService;

import java.util.ArrayList;

/**
 * Created by J on 2020/5/21 9:29
 */
@Service
public class AdminServiceImpl implements IAdminService {
    @Override
    public UserDetails loadUserByUsername(String username) {
        return new AsUserDetails(new User("admin","macro123"),new ArrayList<>());
    }
}
