package xiongjunmiao.top.Website.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import xiongjunmiao.top.Website.domain.Admin;
import xiongjunmiao.top.Website.domain.Permission;
import xiongjunmiao.top.Website.jwtsecurity.utils.JwtTokenUtil;
import xiongjunmiao.top.Website.mapper.PermissionMapper;
import xiongjunmiao.top.Website.service.IAdminService;
import xiongjunmiao.top.Website.service.IPermissionService;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

/**
 *
 */
@Service
public class PermissionServiceImpl extends BaseServiceImpl<Permission> implements IPermissionService {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private IAdminService adminService;

    @Override
    public List<Permission> getPermissionByToken(String token) {

        String name = jwtTokenUtil.getUserNameFromToken(token);
        if(!StringUtils.isEmpty(name)){
            Admin admin = adminService.selectByUserName(name);
            List<Permission> permissions = getPermissionByAdminId(admin.getId());
            return permissions;
        }
        return null;
    }

    @Override
    public List<Permission> getPermissionByAdminId(Long id) {
        List<Permission> permissions = permissionMapper.getPermissionByAdminId(id);
        return permissions;
    }
}
