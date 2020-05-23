package xiongjunmiao.top.Website.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xiongjunmiao.top.Website.domain.AdminRole;
import xiongjunmiao.top.Website.mapper.AdminRoleMapper;
import xiongjunmiao.top.Website.service.IAdminRoleService;

/**
 *
 */
@Service
public class AdminRoleServiceImpl extends BaseServiceImpl<AdminRole> implements IAdminRoleService {

    @Autowired
    private AdminRoleMapper adminRoleMapper;
    @Override
    public void deleteByAdminId(Long adminId) {
        AdminRole adminRole = adminRoleMapper.selectByAdminId(adminId);
        adminRoleMapper.deleteById(adminRole.getId());
    }
}
