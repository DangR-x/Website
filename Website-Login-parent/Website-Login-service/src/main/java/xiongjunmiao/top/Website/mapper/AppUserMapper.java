package xiongjunmiao.top.Website.mapper;

import org.apache.ibatis.annotations.Param;
import xiongjunmiao.top.Website.domain.AppUser;

public interface AppUserMapper  {

    AppUser findByUsername(@Param("username") String username);

}
