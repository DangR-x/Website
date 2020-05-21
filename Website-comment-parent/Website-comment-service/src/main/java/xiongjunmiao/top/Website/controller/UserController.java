package xiongjunmiao.top.Website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xiongjunmiao.top.Website.domain.User;
import xiongjunmiao.top.Website.service.IUserService;

import java.util.List;

/**
 * Created by J on 2020/5/16 13:40
 */
@RestController
@RequestMapping("/comment")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/user")
    public List<User> getUser(){
        List<User> users = userService.selectAll();
        return users;
    }

}
