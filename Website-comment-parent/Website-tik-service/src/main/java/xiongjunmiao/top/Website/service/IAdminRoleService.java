package xiongjunmiao.top.Website.service;

import xiongjunmiao.top.Website.domain.AdminRole;

/**
 * Created by J on 2020/5/22 17:30
 */
public interface IAdminRoleService extends BaseService<AdminRole> {

    void deleteByAdminId(Long adminId);
}
