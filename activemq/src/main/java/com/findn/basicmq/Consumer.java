package com.findn.basicmq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author Guo Yan
 * @date 2020/4/26-17:40
 */
public class Consumer {

    public static void main(String[] args) throws JMSException {
        ConnectionFactory factory = new ActiveMQConnectionFactory(
                "zhangsan",
                "1234",
                "tcp://localhost:61616"
        );

        Connection connection = factory.createConnection();
        connection.start();

        Session session = connection.createSession(Boolean.FALSE,Session.AUTO_ACKNOWLEDGE);

        Destination destination = session.createQueue("second");

        MessageConsumer consumer = session.createConsumer(destination);

        while (true){
            TextMessage msg = (TextMessage) consumer.receive();
            System.out.println("接收到消息：" +msg.getText());
        }


    }

}
