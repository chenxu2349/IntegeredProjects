package org.example.producer;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.List;

/**
 * 分区有序消息生产者
 */
public class OrderMessageProducer {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {


        //  发送消息数量
        final int messageCount = 5;
        // 创建一个producer，参数为生产者组名称
        DefaultMQProducer producer = new DefaultMQProducer("pg");

        producer.setDefaultTopicQueueNums(4);
        // 指定nameServer地址
        producer.setNamesrvAddr("192.168.131.130:9876");
        //开启生产者
        producer.start();

        for (int i = 0; i < messageCount; i++) {
            //订单Id
            Integer orderId = i;

            for(int j=0;j<messageCount;j++){

                byte[] body = ("订单号:" + orderId+"     订单状态:"+j).getBytes();
                //声明Topic和Tags
                Message msg = new Message("orderTopic", "order", body);
                SendResult sendResult = producer.send(msg, new MessageQueueSelector() {

                    //定义消息选择器
                    //orderId会被当做参数传入选择方法select中
                    @Override
                    public MessageQueue select(List<MessageQueue> mqs, Message message, Object orderId) {
                        //拿到订单id
                        Integer id = (Integer) orderId;
                        //mqs是该Topic下的所有的队列集合
                        //这里可以通过订单号和队列长度进行一个取模，保证一个订单的消息可以投递在一个Queue中
                        int index = id % mqs.size();
                        return mqs.get(index);
                    }
                }, orderId);
                System.out.println("发送消息结果:"+sendResult);

            }


        }

        producer.shutdown();

    }
}

