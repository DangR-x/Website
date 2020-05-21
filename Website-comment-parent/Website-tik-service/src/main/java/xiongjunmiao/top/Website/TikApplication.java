package xiongjunmiao.top.Website;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 */
@SpringBootApplication
@MapperScan("xiongjunmiao.top.Website.mapper")
public class TikApplication {
    public static void main(String[] args) {
        SpringApplication.run(TikApplication.class,args);
    }

}
