package xiongjunmiao.top.Website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xiongjunmiao.top.Website.securityconfig.IgnoreUrlsConfig;

import java.util.List;

/**
 * Created by J on 2020/5/20 14:37
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private IgnoreUrlsConfig ignoreUrlsConfig;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/ignore",method = RequestMethod.GET)
    public String getIgnore(){
        List<String> urls = ignoreUrlsConfig.getUrls();
        for (String url : urls) {
            System.out.println(url);
        }
        return urls.get(0);
    }

    @RequestMapping(value = "/password",method = RequestMethod.POST)
    public String getPassword(@RequestBody String password){
        String encode = passwordEncoder.encode(password);
        System.out.println(encode);
        return encode;
    }


}
