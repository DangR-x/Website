package xiongjunmiao.top.Website.uitl.webtokenFilter.service;

import xiongjunmiao.top.Website.uitl.webtokenFilter.userdomain.AppUser;

/**
 * Created by J on 2020/5/8 11:39
 */
public interface UserService {

    public AppUser checkToken(String token);
}
