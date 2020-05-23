package xiongjunmiao.top.Website.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xiongjunmiao.top.Website.domain.*;
import xiongjunmiao.top.Website.mapper.AdminMapper;
import xiongjunmiao.top.Website.mapper.ResourceMapper;
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

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IMenuService menuService;

    @Test
    public void Test7(){

    }

    @Test
    public void Test6(){
        Admin admin = adminMapper.selectByName("测试");
        AdminDetails adminDetails = adminService.loadUserByUsername("测试");
        System.out.println(adminDetails);
    }


    @Test
    public void Test5(){
        List<Menu> menuByAdminId = roleService.getMenuByAdminId(1L);
        for (Menu menu : menuByAdminId) {
            System.out.println(menu);
        }

    }

    @Test
    public void Test4(){
        menuService.deleteById(27L);

    }



    @Test
    public void Test3(){
        List<Role> roles = roleService.selectAll();
        for (Role role : roles) {
            System.out.println(role);
        }

    }

    @Test
    public void Test2(){
        List<Resource> resourceByAminId = resourceMapper.getResourceByAminId(1L);
        for (Resource resource : resourceByAminId) {
            System.out.println(resource);
        }

    }

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