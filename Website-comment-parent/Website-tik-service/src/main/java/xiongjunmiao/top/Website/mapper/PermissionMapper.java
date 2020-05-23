package xiongjunmiao.top.Website.mapper;

import xiongjunmiao.top.Website.domain.Permission;

import java.util.List;

/**
 *
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    List<Permission> getPermissionByAdminId(Long id);
}
