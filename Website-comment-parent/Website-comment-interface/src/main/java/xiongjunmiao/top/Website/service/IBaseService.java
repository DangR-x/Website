package xiongjunmiao.top.Website.service;

import java.io.Serializable;
import java.util.List;

/**
 * @Description TODO
 * @Author DangR-X
 * @Date 2020/4/15 16:24
 * @Version v1.0
 */
public interface IBaseService<T> {


    void add(T t);
    //Serializable是Long，string等等的顶级接口
    void removeById(Serializable id);
    void updateById(T t);
    T getById(Serializable id);
    List<T> getAll();
}
