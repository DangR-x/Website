package xiongjunmiao.top.Website.mapper;



import xiongjunmiao.top.Website.domain.Admin;

import java.io.Serializable;
import java.util.List;


/**
 *
 */
public interface AdminMapper {

    void insert(Admin t);

    //Serializable是Long，string等等的顶级接口
    void deleteById(Serializable id);

    void updateById(Admin t);

    Admin selectById(Serializable id);

    List<Admin> selectAll();

}
