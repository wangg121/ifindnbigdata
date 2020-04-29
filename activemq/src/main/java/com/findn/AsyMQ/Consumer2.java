package com.findn.AsyMQ;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.concurrent.*;

/**
 * @author Guo Yan
 * @date 2020/4/29-10:00
 */
public class Consumer2 {

    private final String SELECTOR_1 = "sex='女'";

    private ConnectionFactory connectionFactory;

    private Connection connection;

    private Session session;

    private MessageConsumer consumer;


    public Consumer2() {

        try {

            this.connectionFactory = new ActiveMQConnectionFactory(
                    "zhangsan",
                    "1234",
                    "tcp://localhost:61616"
            );
            this.connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.FALSE,Session.AUTO_ACKNOWLEDGE);
            consumer = session.createConsumer(session.createQueue("msg"),SELECTOR_1);
            System.out.println("Consuerm2 Start.......");
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
    public void receive(){
        try {
            consumer.setMessageListener(new Listener2());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    class Listener2  implements MessageListener{

        private  BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(10000);

        private ExecutorService factory = new ThreadPoolExecutor(
                Runtime.getRuntime().availableProcessors(),
                20,
                2L,
                TimeUnit.SECONDS,
                queue
        );

        @Override
        public void onMessage(Message message) {
            if(message instanceof TextMessage){

            }else if(message instanceof MapMessage){

                MapMessage msg = (MapMessage)message;
                MessageRunnable task = new MessageRunnable(msg);
                factory.execute(task);
            }
        }
    }

    public static void main(String[] args){
        Consumer2 consumer2 = new Consumer2();
        consumer2.receive();
    }

}
