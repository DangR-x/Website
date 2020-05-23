package xiongjunmiao.top.Website.mapper;

import xiongjunmiao.top.Website.domain.Menu;
import xiongjunmiao.top.Website.domain.Role;

import java.util.List;

/**
 * Created by J on 2020/5/22 14:13
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<Menu> getMenuByAdminId(Long id);

}
