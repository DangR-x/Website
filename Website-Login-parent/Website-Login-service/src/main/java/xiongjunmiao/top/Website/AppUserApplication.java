package xiongjunmiao.top.Website;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import xiongjunmiao.top.Website.domain.AppUser;

/**
 * @Description TODO
 * @Author DangR-X
 * @Date 2020/5/10 16:06
 * @Version v1.0
 */
@SpringBootApplication
@MapperScan("xiongjunmiao.top.Website.mapper")
public class AppUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppUserApplication.class,args);
    }


}
