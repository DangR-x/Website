package xiongjunmiao.top.Website.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xiongjunmiao.top.Website.security.CurrentUser;
import xiongjunmiao.top.Website.security.User;

/**
 * Created by J on 2020/5/14 18:44
 */
@RestController
public class Testcontroller {

    @GetMapping("/")
    public String test(@CurrentUser User user){
        if (user == null) {
            return "login";
        }
        return "employee";
    }

}
