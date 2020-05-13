package xiongjunmiao.top.Website.repeat;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
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
//@Configuration
public class RepeatWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }
}
