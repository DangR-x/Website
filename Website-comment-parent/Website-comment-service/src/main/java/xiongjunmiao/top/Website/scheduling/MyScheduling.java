package xiongjunmiao.top.Website.scheduling;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * Created by J on 2020/5/11 10:12
 */
@Component
@EnableScheduling
public class MyScheduling {


    @Scheduled(cron = "0 */5 * * * ?")
    public void test(){
        System.out.println("这是一个定时器1");
        getAsync();
        System.out.println("唤醒定时器2");
        System.out.println("定时器完成1");

    }
    @Scheduled(cron = "0 */2 * * * ?")
    public void test1(){
        System.out.println("这是一个定时器2");
        getAsync();
        System.out.println("定时器完成2");
    }
    @Async    //java异步调用,不必等这个方法执行完就可以执行后面的代码
    public void getAsync(){

    }
}
