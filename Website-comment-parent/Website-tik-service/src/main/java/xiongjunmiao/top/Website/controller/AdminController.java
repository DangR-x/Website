package xiongjunmiao.top.Website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import xiongjunmiao.top.Website.domain.Admin;
import xiongjunmiao.top.Website.domain.Menu;
import xiongjunmiao.top.Website.dto.AdminParam;
import xiongjunmiao.top.Website.dto.LoginAdminParam;
import xiongjunmiao.top.Website.dto.UpdateAdminPasswordParam;
import xiongjunmiao.top.Website.jwtsecurity.utils.CommonResult;
import xiongjunmiao.top.Website.jwtsecurity.utils.JwtTokenUtil;
import xiongjunmiao.top.Website.service.IAdminService;
import xiongjunmiao.top.Website.service.IRoleService;
import xiongjunmiao.top.Website.service.Impl.AdminServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private IAdminService adminService;

    @Autowired
    private IRoleService roleService;

    //登录
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody LoginAdminParam admin, BindingResult result){
        String token = adminService.login(admin.getName(), admin.getPassword());
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    //注册用户
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Admin> register(@RequestBody AdminParam AdminParam, BindingResult result) {
        CommonResult register = adminService.register(AdminParam);
        return register;
    }

    //获取当前登录用户信息
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAdminInfo(Principal principal) {
        if(principal==null){
            return CommonResult.unauthorized(null);
        }
        String username = principal.getName();
        Admin admin = adminService.selectByUserName(username);
        Map<String, Object> data = new HashMap<>();
        data.put("username", admin.getUsername());
        data.put("roles", new String[]{"TEST"});
        data.put("menus", roleService.getMenuByAdminId(admin.getId()));
        data.put("icon", admin.getIcon());
        return CommonResult.success(data);
    }

    //刷新token
    @RequestMapping(value = "/refreshToken", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult refreshToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshToken = adminService.refreshToken(token);
        if (refreshToken == null) {
            return CommonResult.failed("token已经过期！");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", refreshToken);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    //修改用户密码
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updatePassword(@RequestBody UpdateAdminPasswordParam updatePasswordParam) {
        int status = adminService.updatePassword(updatePasswordParam);
        if (status > 0) {
            return CommonResult.success(status);
        } else if (status == -1) {
            return CommonResult.failed("提交参数不合法");
        } else if (status == -2) {
            return CommonResult.failed("找不到该用户");
        } else if (status == -3) {
            return CommonResult.failed("旧密码错误");
        } else {
            return CommonResult.failed();
        }
    }
    @RequestMapping(value = "/getmenu/{id}",method = RequestMethod.GET)
    @ResponseBody
    public List<Menu> getMenu(@PathVariable("id") Long id){
        System.out.println("menuid"+id);
        List<Menu> menus = adminService.selectMenuByAdminId(id);
        return menus;
    }

    //修改商户操作商品权限
    @RequestMapping(value = "/permission/update", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updatePermission(@RequestParam Long adminId,
                                         @RequestParam("permissionIds") List<Long> permissionIds) {
        int count = adminService.updatePermission(adminId, permissionIds);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }
}
