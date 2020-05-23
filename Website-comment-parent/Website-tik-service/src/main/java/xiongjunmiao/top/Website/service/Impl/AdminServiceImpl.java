package xiongjunmiao.top.Website.service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import xiongjunmiao.top.Website.domain.*;
import xiongjunmiao.top.Website.dto.AdminParam;
import xiongjunmiao.top.Website.dto.UpdateAdminPasswordParam;
import xiongjunmiao.top.Website.jwtsecurity.utils.CommonResult;
import xiongjunmiao.top.Website.jwtsecurity.utils.JwtTokenUtil;
import xiongjunmiao.top.Website.mapper.AdminMapper;
import xiongjunmiao.top.Website.mapper.ResourceMapper;
import xiongjunmiao.top.Website.service.IAdminRoleService;
import xiongjunmiao.top.Website.service.IAdminService;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by J on 2020/5/21 17:03
 */
@Slf4j
@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private IAdminRoleService adminRoleService;

    //用户登录
    @Override
    public String login(String username, String password) {

        String token=null;
        try {
        AdminDetails adminDetails = loadUserByUsername(username);
        if(!passwordEncoder.matches(password,adminDetails.getPassword())){
            return token="密码不正确!";
            //throw new BadCredentialsException("密码不正确");
        }
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(adminDetails, null, adminDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        token = jwtTokenUtil.generateToken(adminDetails);

        } catch (AuthenticationException e) {
            log.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    //通过用户名查询用户,在jwtauthenticaiongfilter中调用判断该用户是否有某个权限
    @Override
    public AdminDetails loadUserByUsername(String name) {
        Admin admin = selectByUserName(name);
        if(admin!=null){
            List<Resource> resources = resourceMapper.getResourceByAminId(admin.getId());
            AdminDetails adminDetails = new AdminDetails(admin,resources);
            return adminDetails;
        }
        throw new UsernameNotFoundException("用户名输入错误!");
    }

    //注册
    @Override
    public CommonResult register(AdminParam adminParam) {
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminParam,admin);
        admin.setCreateTime(new Date());
        admin.setStatus(1);
        Admin userName = selectByUserName(admin.getUsername());
        if(userName != null){
            return CommonResult.failed("用户名已被占用!");
        }
        String encode = passwordEncoder.encode(admin.getPassword());
        admin.setPassword(encode);
        try {
            adminMapper.insert(admin);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed("注册失败请联系管理员!");
        }
        AdminRole adminRole = new AdminRole(admin.getId(),5L);
        adminRoleService.insert(adminRole);
        return CommonResult.success(admin);
    }
    //刷新token
    @Override
    public String refreshToken(String oldtoken) {
        return jwtTokenUtil.refreshHeadToken(oldtoken);
    }

    //返回 -1 用户名为空 -2 没有该用户 -3 旧密码错误
    @Override
    public int updatePassword(UpdateAdminPasswordParam updateAdminPasswordParam) {
        String username = updateAdminPasswordParam.getUsername();
        if(StringUtils.isEmpty(username)){
            return -1;
        }
        Admin admin = selectByUserName(username);
        if(StringUtils.isEmpty(admin)){
            return -2;
        }
        if(!passwordEncoder.matches(updateAdminPasswordParam.getOldPassword(),admin.getPassword())){
            return -3;
        }
        admin.setPassword(passwordEncoder.encode(updateAdminPasswordParam.getNewPassword()));
        adminMapper.updateByName(admin);
        return 1;
    }

    //修改商户商品管理权限
    @Override
    public int updatePermission(Long adminId, List<Long> permissionIds) {
        //通过用户id删除用户的权限
        adminRoleService.deleteByAdminId(adminId);
        return 0;
    }
    //通过用户id查询出所有菜单
    @Override
    public List<Menu> selectMenuByAdminId(Long id){
        List<Menu> menus = adminMapper.selectMenuByAdminId(id);
        return menus;
    }

    @Override
    public void insert(Admin t) {
        adminMapper.insert(t);
    }

    @Override
    public void deleteById(Serializable id) {
        adminMapper.deleteById(id);
    }

    @Override
    public void updateById(Admin t) {
        adminMapper.updateById(t);
    }

    @Override
    public Admin selectById(Serializable id) {
        return adminMapper.selectById(id);
    }

    @Override
    public List<Admin> selectAll() {
        return adminMapper.selectAll();
    }

    @Override
    public Admin selectByUserName(String name) {
        return adminMapper.selectByName(name);
    }


}
