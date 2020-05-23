package xiongjunmiao.top.Website.service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import xiongjunmiao.top.Website.domain.Admin;
import xiongjunmiao.top.Website.domain.Menu;
import xiongjunmiao.top.Website.domain.Role;
import xiongjunmiao.top.Website.mapper.MenuMapper;
import xiongjunmiao.top.Website.mapper.RoleMapper;
import xiongjunmiao.top.Website.service.IAdminService;
import xiongjunmiao.top.Website.service.IRoleService;

import java.util.List;


/**
 *
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private IAdminService adminService;

    @Override
    public List<Menu> getMenuByAdminId(Long id) {
        return roleMapper.getMenuByAdminId(id);
    }


}
