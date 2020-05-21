package xiongjunmiao.top.Website.service;

import org.springframework.security.access.ConfigAttribute;
import xiongjunmiao.top.Website.domain.Admin;
import xiongjunmiao.top.Website.domain.AdminDetails;
import xiongjunmiao.top.Website.jwtsecurity.component.DynamicSecurityService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 *
 */
public interface IAdminService {
    void insert(Admin t);
    //Serializable是Long，string等等的顶级接口
    void deleteById(Serializable id);
    void updateById(Admin t);
    Admin selectById(Serializable id);
    List<Admin> selectAll();
    AdminDetails loadUserByUsername(String name);

}
