package xiongjunmiao.top.Website.mapper;

import xiongjunmiao.top.Website.domain.AdminRole;

/**
 * Created by J on 2020/5/22 17:30
 */
public interface AdminRoleMapper extends BaseMapper<AdminRole> {

    AdminRole selectByAdminId(Long id);
}
