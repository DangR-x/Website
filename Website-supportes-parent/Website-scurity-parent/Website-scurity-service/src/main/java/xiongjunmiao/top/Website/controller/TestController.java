package xiongjunmiao.top.Website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xiongjunmiao.top.Website.domain.AsUserDetails;
import xiongjunmiao.top.Website.domain.User;
import xiongjunmiao.top.Website.securityconfig.IgnoreUrlsConfig;
import xiongjunmiao.top.Website.utils.JwtTokenUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by J on 2020/5/20 14:37
 */
@RestController
@RequestMapping("/admin")
public class TestController {

    @Autowired
    private IgnoreUrlsConfig ignoreUrlsConfig;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

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

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestBody User user, HttpServletRequest request){
        String header = request.getHeader(this.tokenHeader);
        AsUserDetails details = new AsUserDetails(user, new ArrayList<>());
        String s = jwtTokenUtil.generateToken(details);
        return "header:"+header+";"+"token:"+s;
    }

    @RequestMapping(value = "/token",method = RequestMethod.POST)
    public String getTokenTest(@RequestBody String token){
        System.out.println(token);
        return token;
    }


}
