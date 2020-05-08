package xiongjunmiao.top.Website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
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
//@EnableScheduling         //开启定时任务
public class CommentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommentServiceApplication.class,args);
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
    }
    //表示方法执行完成后5秒
//    @Scheduled(fixedDelay = 5000)
//    public void schedulin(){
//        System.out.println("定时任务");
//    }
}
