package com.ifindn.base;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Author Mr.Guo
 * @Date 2020-06-25 7:43
 * zk客户端和服务端会话的建立是一个异步的过程，也就是说在程序中，我们程序方法在处理客户端初始化后
 * 立即返回（也就是说程序往下执行代码，这样，大多数情况下我们并没有真正构建好一个可用会话，会话的生命周期
 * 处于“CONNECTING”时才算真正建立完毕，）
 */
public class ZooKeeperBase {

    //zk地址
    static final String CONNECT_ADDR = "192.168.184.10";
    //超时时间
    static final int SESSION_OUTTIME = 5000;
    //阻塞程序执行，用于等待zk连接成功，发送成功信号
    static final CountDownLatch connectedSemaphore = new CountDownLatch(1);

    public static void main(String[] args) throws Exception {
        ZooKeeper zooKeeper = new ZooKeeper(CONNECT_ADDR, SESSION_OUTTIME, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                //获取时间状态
                Event.KeeperState keeperState = watchedEvent.getState();
                Event.EventType type = watchedEvent.getType();

                //如果建立连接
                if (Event.KeeperState.SyncConnected == keeperState) {
                    if (Event.EventType.None == type) {
                        //如果连接成功，则发送信号量，让后续阻塞程序向下执行
                        connectedSemaphore.countDown();
                        System.out.println("zk 建立连接");
                    }
                }
            }
        });

        //进行阻塞
        connectedSemaphore.await();

//        zooKeeper.create("/testRoot", "/testRoot".getBytes(),
//                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        List<String> list = zooKeeper.getChildren("/testRoot",false);

        for (String path:list) {
            String absoutPath = "/testRoot/" + path;

            System.out.println(new String(zooKeeper.getData(absoutPath,false,null)));
        }

        zooKeeper.close();
    }
}
