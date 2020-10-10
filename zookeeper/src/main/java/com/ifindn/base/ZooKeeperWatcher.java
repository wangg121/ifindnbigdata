package com.ifindn.base;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import sun.applet.Main;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Mr.Guo
 * @Date 2020-06-26 19:26
 */
public class ZooKeeperWatcher implements Watcher {
    //定义原子变量
    private AtomicInteger seq = new AtomicInteger();
    public static final int SESSION_TIMEOUT = 5000;
    public static final String CONNECT_ADDR = "192.168.184.10";
    //zk父路径设置
    public static final String PARENT_PATH = "/p";
    //zk子路径设置
    public static final String CHILDREN_PATH = "/p/c";

    public static final String LOG_PREFIX_OF_MAIN = "[Main]";
    private ZooKeeper zk = null;
    //用于zookeeper建立连接后，通知阻塞继续向下执行
    private CountDownLatch connectedSemaphore = new CountDownLatch(1);

    //创建连接
    public void createConnected(int timeout ,String address){
        try {
            this.realeaseConnect();
            zk = new ZooKeeper(address, timeout,this);
            System.out.println("zk开始连接服务器");
            this.connectedSemaphore.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //关闭zk连接
    public void realeaseConnect(){
        if(zk != null){
            try {
                zk.close();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteNode(String path){
        try {
            this.zk.delete(path,-1);
            System.out.println("删除" + path + "节点");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    public Stat exists(String path,boolean needWathch){

        try {
            return this.zk.exists(path,needWathch);
        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }
    }

    public boolean createPath(String path,String data,boolean needWatch){
        try {
            //设置监控，由于zookeeper的监控都是一次性的，所以每次必须设置监控
            this.zk.exists(path,needWatch);
            System.out.println(LOG_PREFIX_OF_MAIN + "节点创建成功 path:" +
                    this.zk.create(path,data.getBytes(),
                            ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT)
            +" content " + data);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public String redaData(String path,boolean needWatch){
        byte[] bytes = null;
        try {
            bytes = this.zk.getData(path,needWatch,this.exists(path,needWatch));

        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new String(bytes);
    }
    @Override
    public void process(WatchedEvent watchedEvent) {

        System.out.println("进入process...event = " + watchedEvent);

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(watchedEvent == null){
            return;
        }

        Event.KeeperState state = watchedEvent.getState();
        Event.EventType type = watchedEvent.getType();
        //受影响的路径
        String path = watchedEvent.getPath();
        //原子对象进入process的次数
        String prefix = "[watcher-" + this.seq.incrementAndGet() + "]";

        System.out.println(prefix + " 收到watcher通知");

        if(Event.KeeperState.SyncConnected == state){
            //成功连接上zk服务器
            if(Event.EventType.None == type){
                System.out.println(prefix + " 成功连接上服务器");
                this.connectedSemaphore.countDown();
            }else if(Event.EventType.NodeCreated == type){
                System.out.println(prefix + "节点创建");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else if (Event.EventType.NodeChildrenChanged == type){
                System.out.println(prefix + "节点变更");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else if(Event.EventType.NodeDeleted == type){
                System.out.println(prefix + "节点删除");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }else if(Event.KeeperState.Disconnected == state){
            System.out.println(prefix + "与服务器断开连接");
        }else if (Event.KeeperState.AuthFailed == state){
            System.out.println(prefix + "权限验证失败");
        }else if(Event.KeeperState.Expired == state){
            System.out.println(prefix + "会话失效");
        }

        System.out.println("---------------------------------------------");

    }


}
