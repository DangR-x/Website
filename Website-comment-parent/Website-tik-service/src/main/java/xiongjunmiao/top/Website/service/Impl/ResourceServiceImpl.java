package xiongjunmiao.top.Website.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xiongjunmiao.top.Website.domain.Resource;
import xiongjunmiao.top.Website.mapper.ResourceMapper;
import xiongjunmiao.top.Website.service.IResourceService;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
@Service
public class ResourceServiceImpl implements IResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public void insert(Resource t) {
        resourceMapper.insert(t);
    }

    @Override
    public void deleteById(Serializable id) {
        resourceMapper.deleteById(id);
    }

    @Override
    public void updateById(Resource t) {
        resourceMapper.updateById(t);
    }

    @Override
    public Resource selectById(Serializable id) {
        return resourceMapper.selectById(id);
    }

    @Override
    public List<Resource> selectAll() {
        return resourceMapper.selectAll();
    }

    @Override
    public List<Resource> getResourceByAminId(Long adminid) {
        return resourceMapper.getResourceByAminId(adminid);
    }


}
