package xiongjunmiao.top.Website.service;

import xiongjunmiao.top.Website.domain.Menu;
import xiongjunmiao.top.Website.domain.Role;

import java.util.List;

/**
 *
 */
public interface IRoleService extends BaseService<Role> {

    List<Menu> getMenuByAdminId(Long id);

}
