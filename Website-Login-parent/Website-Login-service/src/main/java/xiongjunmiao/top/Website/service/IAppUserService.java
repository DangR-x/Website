package xiongjunmiao.top.Website.service;

import xiongjunmiao.top.Website.domain.AppUser;

/**
 * Created by J on 2020/5/8 11:39
 */
public interface IAppUserService  {

    AppUser checkToken(String token);

    AppUser findByUsername(String username);

}
