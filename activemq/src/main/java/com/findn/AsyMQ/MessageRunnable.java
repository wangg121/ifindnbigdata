package com.findn.AsyMQ;

import javax.jms.JMSException;
import javax.jms.MapMessage;

/**
 * @author Guo Yan
 * @date 2020/4/29-10:11
 */
public class MessageRunnable implements Runnable {

    private MapMessage mapMessage;

    public MessageRunnable(MapMessage mapMessage){
        this.mapMessage = mapMessage;
    }


    @Override
    public void run() {

        try {
            System.out.println("接收的消息性别为" + mapMessage.getStringProperty("sex") + mapMessage );
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
