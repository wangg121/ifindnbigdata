package com.findn.basicmq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.concurrent.TimeUnit;

/**
 * @author Guo Yan
 * @date 2020/4/26-16:05
 */
public class Procuder {
    
    public static void main(String[] args){
        //第一步：建立ConnectionFactory工厂对象，需要填入用户名和密码，以及连接的地址，均使用默认即可，
        //默认端口，“tcp://localhost:61616”
        ConnectionFactory factory = new ActiveMQConnectionFactory(
                ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD,
                "tcp://localhost:61616" //连接mq服务器的地址，采用的是tcp通信
        );

        /*第二步，通过ConnectionFactory工厂对象我们创建一个Connection连接，并且调用Connection的start方法开启连接，
        Connection默认是关闭的。*/
        Connection conn = null;
        try {
            conn = factory.createConnection();
            conn.start();

            /*第三步，通过Connection对象创建Session会话（上下文环境），用于接收消息，
            参数1为是否启用事务，参数2为签收模式，一般设置为自动签收*/
            Session session = conn.createSession(Boolean.FALSE,Session.AUTO_ACKNOWLEDGE);

            /*第四步：通过Session创建destiantion对象，指的是一个客户端用来指定生产生产消息目标和消费信息来源的对象，
            在PTP模式中，Destination被称作Queue即队列，
            */
            Destination destination = session.createQueue("first");

            /**
             *第五步：通过Session对象创建消息的发送和接收对象，生产者和消费者，MessageProducer/MessageConusmer
             */
            MessageProducer producer = session.createProducer(null);

            /*
            第六步：可以使用MessageProcuder的SetDeliveryMode方法为其设置持久化特性和非持久化特性（DeliveryMode）
             */

            /**
             * 第七步：使用JMS规范的TextMessage形式创建数据（通过Session对象），并用MessageProcuder的send方法发送数据，
             * 同理客户端使用receive方法进行接收
             */
            for (int i = 0; i < 100 ; i++) {
                TextMessage msg = session.createTextMessage("发送的消息为：" + i);
                //或者用msg.setText(arg);

                /*
                第一个参数目标地址
                第二个参数具体的数据信息
                第三个参数传送数据的模式,持久化或非持久化
                第四个参数优先级
                第五个参数消息的过期时间
                 */
                producer.send(destination,msg);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        } catch (JMSException e) {
            e.printStackTrace();
        }

        if(conn !=null){
            try {
                conn.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }

    }
    

}
