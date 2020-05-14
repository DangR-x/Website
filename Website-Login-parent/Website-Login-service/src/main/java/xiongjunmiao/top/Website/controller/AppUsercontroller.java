package xiongjunmiao.top.Website.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import xiongjunmiao.top.Website.domain.AppUser;
import xiongjunmiao.top.Website.service.IAppUserService;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Description TODO
 * @Author DangR-X
 * @Date 2020/5/10 16:02
 * @Version v1.0
 */
@RestController
@RequestMapping("/appuser")
public class AppUsercontroller {

    @Resource(name = "captchaProducer")
    private Producer captchaProducer;

    @Resource(name = "captchaProducerMath")
    private Producer captchaProducerMath;

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

    /**
     * 验证码生成
     */
    @GetMapping(value = "/captchaImage")
    public ModelAndView getKaptchaImage(HttpServletRequest request, HttpServletResponse response)
    {
        ServletOutputStream out = null;
        try
        {
            HttpSession session = request.getSession();
            response.setDateHeader("Expires", 0);
            response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
            response.addHeader("Cache-Control", "post-check=0, pre-check=0");
            response.setHeader("Pragma", "no-cache");
            response.setContentType("image/jpeg");

            String type = request.getParameter("type");
            String capStr = null;
            String code = null;
            BufferedImage bi = null;
            if ("math".equals(type))
            {
                String capText = captchaProducerMath.createText();
                capStr = capText.substring(0, capText.lastIndexOf("@"));
                code = capText.substring(capText.lastIndexOf("@") + 1);
                bi = captchaProducerMath.createImage(capStr);
            }
            else if ("char".equals(type))
            {
                capStr = code = captchaProducer.createText();
                bi = captchaProducer.createImage(capStr);
            }
            session.setAttribute(Constants.KAPTCHA_SESSION_KEY, code);
            out = response.getOutputStream();
            ImageIO.write(bi, "jpg", out);
            out.flush();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (out != null)
                {
                    out.close();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return null;
    }

    @GetMapping("/test")
    public String controllertest(HttpServletRequest request, HttpServletResponse response){

            HttpSession session = request.getSession();
            response.setDateHeader("Expires", 0);
            response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
            response.addHeader("Cache-Control", "post-check=0, pre-check=0");
            response.setHeader("Pragma", "no-cache");
            response.setContentType("image/jpeg");

            String type = request.getParameter("type");
            System.out.println(type.toString());

        return type.toString();

    }


}
