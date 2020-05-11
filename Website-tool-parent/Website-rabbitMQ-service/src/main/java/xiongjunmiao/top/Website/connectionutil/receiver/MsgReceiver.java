package xiongjunmiao.top.Website.connectionutil.receiver;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import xiongjunmiao.top.Website.connectionutil.ConnectionUtil;

import java.io.IOException;

/**
 * Created by J on 2020/5/11 17:06
 */
@Slf4j
@Component
@RabbitListener(queues = ConnectionUtil.QUEUE_A)
public class MsgReceiver {

    @RabbitHandler
    public void proces(String content, Channel channel, Message message){
        log.info("接收处理队列A当中的消息： {}" , content);
        //告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了 否则消息服务器以为这条消息没处理掉 后续还会在发
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (IOException e) {
            //丢弃这条消息
            //channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
            e.printStackTrace();
        }
    }




}
