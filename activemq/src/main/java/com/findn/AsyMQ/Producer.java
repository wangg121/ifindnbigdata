package com.findn.AsyMQ;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author Guo Yan
 * @date 2020/4/29-9:13
 */
public class Producer {

    private ConnectionFactory connectionFactory;

    private Connection connection;

    private Session session;

    private MessageProducer producer;

    private Destination destination;

    public Producer(){
        try {
            this.connectionFactory = new ActiveMQConnectionFactory(
                    "zhangsan",
                    "1234",
                    "tcp://localhost:61616"
            );
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.FALSE,Session.AUTO_ACKNOWLEDGE);
            producer = session.createProducer(null);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void send(){
        try {

            this.destination = session.createQueue("msg");


            MapMessage msg1 = session.createMapMessage();
            msg1.setString("name","zhangsan");
            msg1.setString("tall","165");
            msg1.setStringProperty("sex","女");
            MapMessage msg2 = session.createMapMessage();
            msg2.setString("name","lisi");
            msg2.setString("tall","175");
            msg2.setStringProperty("sex","女");
            MapMessage msg3 = session.createMapMessage();
            msg3.setString("name","wangwu");
            msg3.setString("tall","185");
            msg3.setStringProperty("sex","男");
            MapMessage msg4 = session.createMapMessage();
            msg4.setString("name","zhaoliu");
            msg4.setString("tall","195");
            msg4.setStringProperty("sex","男");


            producer.send(destination,msg1, DeliveryMode.PERSISTENT, 2,1000*60L);
            producer.send(destination,msg2, DeliveryMode.PERSISTENT, 4,1000*60L);
            producer.send(destination,msg3, DeliveryMode.PERSISTENT, 6,1000*60L);
            producer.send(destination,msg4, DeliveryMode.PERSISTENT, 8,1000*60L);

            System.out.println("发送消息结束");

        } catch (JMSException e) {
            e.printStackTrace();
        }


    }

    public void close(){
        try {
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        Producer producer = new Producer();
        producer.send();
        producer.close();

    }

}
