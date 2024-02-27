package org.example.producer;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * 生产者发送同步消息
 * */
public class SyncSendProducer {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {

        int count = 10;
        // 创建一个producer，参数为生产者组名称
        DefaultMQProducer producer = new DefaultMQProducer("apg");
        // 指定nameServer地址
        producer.setNamesrvAddr("101.35.244.157:9876");
        // 设置当发送失败时重试发送的次数，默认为2次
        producer.setRetryTimesWhenSendFailed(3);
        // 设置发送超时时限为5s，默认3s
        producer.setSendMsgTimeout(5000);
        // 开启生产者
        producer.start();
        // 生产并发送100条消息
        for (int i = 0; i < count; i++) {

            byte[] body = ("Hi," + i).getBytes();
            Message msg = new Message("TopicTest", "someTag", body);
            // 为消息指定key
            msg.setKeys("key_" + i);
            // 发送消息
            SendResult sendResult = producer.send(msg);

            System.out.println(sendResult);
        }
        // 关闭生产者
        producer.shutdown();
    }
}


