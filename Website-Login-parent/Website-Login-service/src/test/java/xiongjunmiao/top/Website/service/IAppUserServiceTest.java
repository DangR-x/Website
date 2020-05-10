package xiongjunmiao.top.Website.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xiongjunmiao.top.Website.domain.AppUser;
import xiongjunmiao.top.Website.mapper.AppUserMapper;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IAppUserServiceTest {


    @Autowired
    private AppUserMapper appUserMapper;

    @Test
    public void test01(){
        AppUser admin = appUserMapper.findByUsername("admin");
        System.out.println(admin);
    }

}