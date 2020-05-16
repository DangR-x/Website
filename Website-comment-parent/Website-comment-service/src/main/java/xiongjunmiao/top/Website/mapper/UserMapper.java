package xiongjunmiao.top.Website.mapper;



import xiongjunmiao.top.Website.domain.User;

import java.io.Serializable;
import java.util.List;

/**
 * Created by J on 2020/5/14 16:11
 */
public interface UserMapper {

    void insert(User t);
    //Serializable是Long，string等等的顶级接口
    void deleteById(Serializable id);
    void updateById(User t);
    User selectById(Serializable id);
    List<User> selectAll1();
}
