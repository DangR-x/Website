package xiongjunmiao.top.Website.repeat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *   WebMvcConfigurer接口
 *      1 addInterceptors：拦截器
 *      2 addViewControllers：页面跳转
 *      3 addResourceHandlers：静态资源
 *      4 configureDefaultServletHandling：默认静态资源处理器
 *      5 configureViewResolvers：视图解析器
 *      6 configureContentNegotiation：配置内容裁决的一些参数
 *      7 addCorsMappings：跨域
 *      8 configureMessageConverters：信息转换器
 */
@Configuration
public class RepeatWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    private RepeatSubmitInterceptor repeatSubmitInterceptor;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //将动态页面employee映射到/admin的url下
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/employee").setViewName("employee");
    }

    /**
     * 自定义拦截规则,将防止重复提交表单过滤器注册进去
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        //registry.addInterceptor(repeatSubmitInterceptor).addPathPatterns("/**");
    }
}
