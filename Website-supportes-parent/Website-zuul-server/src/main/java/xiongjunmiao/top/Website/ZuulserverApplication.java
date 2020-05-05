package xiongjunmiao.top.Website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Description TODO
 * @Author dangran
 * @Date 2020/4/13 22:51
 * @Version v1.0
 */
@SpringBootApplication
@EnableZuulProxy            //标识启动网关配置
public class ZuulserverApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulserverApplication.class,args);
    }
}
