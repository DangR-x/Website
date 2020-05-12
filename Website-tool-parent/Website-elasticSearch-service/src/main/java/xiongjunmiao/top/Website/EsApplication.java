package xiongjunmiao.top.Website;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * Created by J on 2020/5/12 14:17
 */
@MapperScan("xiongjunmiao.top.Website.mapper")
@SpringBootApplication
//@EnableElasticsearchRepositories(basePackages = "xiongjunmiao.top.Website.repository")
public class EsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsApplication.class,args);
    }
}
