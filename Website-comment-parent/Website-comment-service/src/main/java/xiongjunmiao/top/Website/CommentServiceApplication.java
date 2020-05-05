package xiongjunmiao.top.Website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * @Description TODO
 * @Author dangran
 * @Date 2020/4/13 23:03
 * @Version v1.0
 */
@SpringBootApplication
//将mapper注册进spring容器当中
@MapperScan("xiongjunmiao.top.Website.mapper")
public class CommentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommentServiceApplication.class,args);
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
    }
}
