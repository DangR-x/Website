package xiongjunmiao.top.Website.service.impl;

import xiongjunmiao.top.Website.Mapper.BaseMapper;
import xiongjunmiao.top.Website.service.IBaseService;

import java.io.Serializable;
import java.util.List;

/**
 * @Description TODO
 * @Author DangR-X
 * @Date 2020/4/15 16:26
 * @Version v1.0
 */
public abstract class BaseServiceImpl<T> implements IBaseService<T> {


    //在继承BaseServiceImpl的时候重写setMapper方法，注入baseMapper
    protected abstract BaseMapper<T> getBaseMapper();

    @Override
    public void add(T t) {
        getBaseMapper().insert(t);
    }

    @Override
    public void removeById(Serializable id) {
        getBaseMapper().deleteById(id);
    }

    @Override
    public void updateById(T t) {
        getBaseMapper().updateById(t);
    }

    @Override
    public T getById(Serializable id) {
        return getBaseMapper().selectById(id);
    }

    @Override
    public List<T> getAll() {
        List<T> list = getBaseMapper().selectAll();
        return list;
    }
}
