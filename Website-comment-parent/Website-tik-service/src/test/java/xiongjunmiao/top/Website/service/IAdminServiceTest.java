package xiongjunmiao.top.Website.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xiongjunmiao.top.Website.domain.Admin;
import xiongjunmiao.top.Website.mapper.AdminMapper;
import xiongjunmiao.top.Website.service.Impl.AdminServiceImpl;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IAdminServiceTest {

    @Autowired
    private IAdminService adminService;

    @Autowired
    private AdminMapper adminMapper;

    @Test
    public void Test(){
        List<Admin> admins = adminService.selectAll();
        if(admins!=null){
            for (Admin admin : admins) {
                System.out.println(admin);
            }
        }
        Admin admin = adminMapper.selectById(1L);
        System.out.println(admin);

    }

    @Test
    public void Test1(){

        Admin admin = new Admin();
        admin.setCreateTime(new Date());
        admin.setNickName("测试的");
        admin.setStatus(1);
        adminMapper.insert(admin);

    }


}