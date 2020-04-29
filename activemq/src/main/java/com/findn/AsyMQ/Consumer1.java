package com.findn.AsyMQ;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.concurrent.*;

/**
 * @author Guo Yan
 * @date 2020/4/29-10:00
 */
public class Consumer1 {

    private final String SELECTOR_1 = "sex='男'";

    private ConnectionFactory connectionFactory;

    private Connection connection;

    private Session session;

    private MessageConsumer consumer;


    public Consumer1() {

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
            System.out.println("Consuerm1 Start.......");
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void receive(){
        try {
            consumer.setMessageListener(new Listener1());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }


    class Listener1  implements MessageListener{

        private  BlockingQueue<Runnable> queue = new LinkedBlockingDeque<>();

        private ExecutorService factory = new ThreadPoolExecutor(
                Runtime.getRuntime().availableProcessors(),
                20,
                120L,
                TimeUnit.SECONDS,
                queue);


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
        Consumer1 consumer1 = new Consumer1();
        consumer1.receive();
        System.out.println("系统的线程核心数：" + Runtime.getRuntime().availableProcessors());
    }

}
