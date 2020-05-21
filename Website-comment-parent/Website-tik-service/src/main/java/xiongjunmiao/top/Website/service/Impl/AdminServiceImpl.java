package xiongjunmiao.top.Website.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.stereotype.Service;
import xiongjunmiao.top.Website.domain.Admin;
import xiongjunmiao.top.Website.domain.AdminDetails;
import xiongjunmiao.top.Website.mapper.AdminMapper;
import xiongjunmiao.top.Website.service.IAdminService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by J on 2020/5/21 17:03
 */
@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;


    @Override
    public void insert(Admin t) {

    }

    @Override
    public void deleteById(Serializable id) {

    }

    @Override
    public void updateById(Admin t) {

    }

    @Override
    public Admin selectById(Serializable id) {
        return null;
    }

    @Override
    public List<Admin> selectAll() {
        return null;
    }

    @Override
    public AdminDetails loadUserByUsername(String name) {
        return null;
    }
}
