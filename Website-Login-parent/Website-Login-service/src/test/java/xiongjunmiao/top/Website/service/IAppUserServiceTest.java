package xiongjunmiao.top.Website.service;

import com.google.code.kaptcha.Producer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xiongjunmiao.top.Website.domain.AppUser;
import xiongjunmiao.top.Website.mapper.AppUserMapper;
import xiongjunmiao.top.Website.mapper.UserMapper;

import javax.annotation.Resource;

import java.awt.image.BufferedImage;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IAppUserServiceTest {

    @Resource(name = "captchaProducer")
    private Producer captchaProducer;

    @Resource(name = "captchaProducerMath")
    private Producer captchaProducerMath;

    @Autowired
    private AppUserMapper appUserMapper;




    @Test
    public void test01(){
        AppUser admin = appUserMapper.findByUsername("admin");
        System.out.println(admin);
    }


    @Test
    public void test02(){
        String capText = captchaProducerMath.createText();
        String capStr = capText.substring(0, capText.lastIndexOf("@"));
        String code = capText.substring(capText.lastIndexOf("@") + 1);
        BufferedImage bi = captchaProducerMath.createImage(capStr);
    }
    @Test
    public void test03(){

    }

}