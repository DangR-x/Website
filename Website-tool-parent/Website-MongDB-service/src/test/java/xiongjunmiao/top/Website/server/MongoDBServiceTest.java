package xiongjunmiao.top.Website.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xiongjunmiao.top.Website.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoDBServiceTest {

    @Autowired
    private MongoDBService mongoDBService;

    @Test
    public void test(){
        User l = mongoDBService.findByName("芒果");

        System.out.println(l);
    }
}