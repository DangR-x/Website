package xiongjunmiao.top.Website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import xiongjunmiao.top.Website.domain.AppUser;
import xiongjunmiao.top.Website.service.IAppUserService;

/**
 * @Description TODO
 * @Author DangR-X
 * @Date 2020/5/10 16:02
 * @Version v1.0
 */
@RestController
@RequestMapping("/appuser")
public class AppUsercontroller {

    @Autowired
    private IAppUserService appUserService;

    @GetMapping("/employee")
    //@RequestMapping(value = "/{username}",method = RequestMethod.GET)
    public ModelAndView getMav(ModelAndView mav){
        mav.setViewName("employee");
        return mav;
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login1(@RequestBody AppUser appUser){
        ModelAndView model = new ModelAndView();
        System.out.println(appUser.getUsername());
        AppUser byUsername = appUserService.findByUsername(appUser.getUsername());
        System.out.println(byUsername);
        model.setViewName("appuser");
        model.addObject("appuser",byUsername);
        return model;
    }




}
