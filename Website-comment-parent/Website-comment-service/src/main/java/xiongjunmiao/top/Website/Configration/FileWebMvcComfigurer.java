package xiongjunmiao.top.Website.Configration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by J on 2020/5/19 15:58
 */
@Configuration
public class FileWebMvcComfigurer implements WebMvcConfigurer {


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //表示E:/xiong/imagex/下的文件解析成/xiong/**的路径可以访问,
        registry.addResourceHandler("/xiong/**").addResourceLocations("file:E:/xiong/imagex/");
    }
}
