package xiongjunmiao.top.Website.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xiongjunmiao.top.Website.domain.User;
import xiongjunmiao.top.Website.mapper.UserMapper;
import xiongjunmiao.top.Website.service.IUserService;

import java.io.Serializable;
import java.util.List;


/**
 * Created by J on 2020/5/8 11:40
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper UserMapper;


    @Override
    public void insert(User t) {
        UserMapper.insert(t);
    }

    @Override
    public void deleteById(Serializable id) {
        UserMapper.deleteById(id);
    }

    @Override
    public void updateById(User t) {
        UserMapper.updateById(t);
    }

    @Override
    public User selectById(Serializable id) {
        return UserMapper.selectById(id);
    }

    @Override
    public List<User> selectAll() {
        return UserMapper.selectAll1();
    }


}
