package xiongjunmiao.top.Website.securityconfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IgnoreUrlsConfigTest {



    @Test
    public void test(){
        IgnoreUrlsConfig ignoreUrlsConfig = new IgnoreUrlsConfig();
        List<String> urls = ignoreUrlsConfig.getUrls();
        for (String url : urls) {
            System.out.println("url:"+url);
        }
    }


}