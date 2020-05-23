package xiongjunmiao.top.Website.service;


import xiongjunmiao.top.Website.domain.Admin;
import xiongjunmiao.top.Website.domain.AdminDetails;
import xiongjunmiao.top.Website.domain.Menu;
import xiongjunmiao.top.Website.dto.AdminParam;
import xiongjunmiao.top.Website.dto.UpdateAdminPasswordParam;
import xiongjunmiao.top.Website.jwtsecurity.utils.CommonResult;


import java.io.Serializable;
import java.util.List;


/**
 *
 */
public interface IAdminService {

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username,String password);

    void insert(Admin t);
    //Serializable是Long，string等等的顶级接口
    void deleteById(Serializable id);
    void updateById(Admin t);
    Admin selectById(Serializable id);
    List<Admin> selectAll();
    Admin selectByUserName(String name);
    AdminDetails loadUserByUsername(String name);
    CommonResult register(AdminParam admin);
    String refreshToken(String oldtoken);
    int updatePassword(UpdateAdminPasswordParam updateAdminPasswordParam);
    int updatePermission(Long adminId,List<Long> permissionIds);
    List<Menu> selectMenuByAdminId(Long id);

}
