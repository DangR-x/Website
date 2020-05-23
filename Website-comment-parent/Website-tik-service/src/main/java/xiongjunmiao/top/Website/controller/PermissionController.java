package xiongjunmiao.top.Website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xiongjunmiao.top.Website.domain.Permission;
import xiongjunmiao.top.Website.service.IPermissionService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    //通过token获取用户的permission
    @RequestMapping(value = "/getpermission/{token}",method = RequestMethod.GET)
    public List<Permission> getPermission(@PathVariable("token")String token,HttpServletRequest request){
        String authorization = request.getHeader("Authorization");
        System.out.println("authorization:"+authorization);
        List<Permission> permissions = permissionService.getPermissionByToken(token);
        return permissions;
    }


}
