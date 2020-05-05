package xiongjunmiao.top.Website.Mapper;

import java.io.Serializable;
import java.util.List;

/**
 * @Description TODO
 * @Author dangran
 * @Date 2020/4/15 16:09
 * @Version v1.0
 */
public interface BaseMapper<T> {

    void insert(T t);
    //Serializable是Long，string等等的顶级接口
    void deleteById(Serializable id);
    void updateById(T t);
    T selectById(Serializable id);
    List<T> selectAll();


}
