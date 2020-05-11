package xiongjunmiao.top.Website.connectionutil.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xiongjunmiao.top.Website.connectionutil.ConnectionUtil;

import java.util.Random;
import java.util.UUID;

/**
 * 消息发布者
 */
@Slf4j
@Component
public class Mqproducer implements RabbitTemplate.ConfirmCallback {

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public Mqproducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate=rabbitTemplate;
        //如果rabbitTemplate为单例的话,那回调就是最后设置的内容
        rabbitTemplate.setConfirmCallback(this);
    }

    public void setMessge(String content){
        // CorrelationData  该数据的作用是给每条消息一个唯一的标识
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        //将消息设置进入指定的交换机和消息队列中
        rabbitTemplate.convertAndSend(ConnectionUtil.EXCHANGE_A,ConnectionUtil.ROUTINGKEY_A,content,correlationData);

    }
    //发消息到广播交换机下,配置routinkey也无效
    public void sendAll(String content) {
        rabbitTemplate.convertAndSend("fanoutExchange","", content);
    }


    //消息回调
    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        log.debug("消息回调"+correlationData);
        if(b){
            System.out.println("消息发送成功!");
        }else {
            System.out.println("消息发送失败!");
        }
    }
}
