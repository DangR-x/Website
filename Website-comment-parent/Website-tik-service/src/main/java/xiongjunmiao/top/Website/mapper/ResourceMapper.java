package xiongjunmiao.top.Website.mapper;

import org.springframework.stereotype.Component;
import xiongjunmiao.top.Website.domain.Admin;
import xiongjunmiao.top.Website.domain.Resource;

import java.io.Serializable;
import java.util.List;

/**
 * Created by J on 2020/5/22 10:08
 */
@Component
public interface ResourceMapper {

    void insert(Resource t);

    //Serializable是Long，string等等的顶级接口
    void deleteById(Serializable id);

    void updateById(Resource t);

    Resource selectById(Serializable id);

    List<Resource> selectAll();

    List<Resource> getResourceByAminId(Long adminid);


}
