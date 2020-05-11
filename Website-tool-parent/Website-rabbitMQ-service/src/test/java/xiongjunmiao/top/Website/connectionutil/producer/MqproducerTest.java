package xiongjunmiao.top.Website.connectionutil.producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MqproducerTest {

    @Autowired
    private Mqproducer mqproducer;
    @Test
    public void test(){
        mqproducer.setMessge("来呀消费啊");
    }
}