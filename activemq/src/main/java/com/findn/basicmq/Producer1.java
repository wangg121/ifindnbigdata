package com.findn.basicmq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author Guo Yan
 * @date 2020/4/27-8:44
 * 安全认证的配置是在conf/activemq.xml中的</shutdownHooks>后面填加一个插件，
 * <plugins>
 * 			<simpleAuthenticationPlugin>
 * 				<users>
 * 					<authenticationUser username="zhangsan" password="1234" groups="users,admin"/>
 * 				</users>
 * 			</simpleAuthenticationPlugin>
 * 		</plugins>
 * 	这种的是简单的模式，还有复杂的模式。
 */
public class Producer1 {
    public static void main(String[] args){
        ConnectionFactory factory = new ActiveMQConnectionFactory(
                "zhangsan",
          "1234",
          "tcp://localhost:61616"
        );

        Connection connection = null;

        try {
            connection = factory.createConnection();
            connection.start();

            Session session = connection.createSession(Boolean.FALSE,Session.AUTO_ACKNOWLEDGE);


            Destination destination = session.createQueue("second");

            MessageProducer producer = session.createProducer(null);

            for (int i = 0; i < 100 ; i++) {
                TextMessage msg = session.createTextMessage();
                msg.setText("生产消息" + i);

                producer.send(destination,msg);

            }

            if(connection != null){
                connection.close();
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }




    }

}
