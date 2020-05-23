package xiongjunmiao.top.Website.mapper;



import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import xiongjunmiao.top.Website.domain.Admin;
import xiongjunmiao.top.Website.domain.Menu;
import xiongjunmiao.top.Website.domain.Role;
import xiongjunmiao.top.Website.dto.UpdateAdminPasswordParam;

import java.io.Serializable;
import java.util.List;


/**
 *
 */
@Component
public interface AdminMapper {

    void insert(Admin t);

    //Serializable是Long，string等等的顶级接口
    void deleteById(Serializable id);

    void updateById(Admin t);

    Admin selectById(Serializable id);

    List<Admin> selectAll();

    Admin selectByName(String username);

    void updateByName(Admin admin);

    List<Menu> selectMenuByAdminId(Long id);



}
