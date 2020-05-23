package xiongjunmiao.top.Website.service;

import xiongjunmiao.top.Website.domain.Permission;

import java.util.List;

/**
 * Created by J on 2020/5/22 18:22
 */
public interface IPermissionService extends BaseService<Permission> {

    List<Permission> getPermissionByToken(String token);

    List<Permission> getPermissionByAdminId(Long id);

}
