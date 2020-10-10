package com.ifindn.base;

/**
 * @Author Mr.Guo
 * @Date 2020-06-27 9:55
 */
public class TestZooKeeper {

    public static void main(String[] args) throws Exception {
        ZooKeeperWatcher zooKeeperWatcher = new ZooKeeperWatcher();
        zooKeeperWatcher.createConnected(ZooKeeperWatcher.SESSION_TIMEOUT, ZooKeeperWatcher.CONNECT_ADDR);


        Thread.sleep(1000);


        if (zooKeeperWatcher.createPath(ZooKeeperWatcher.CHILDREN_PATH,
                System.currentTimeMillis() + "", false)) {
            Thread.sleep(1000);
            zooKeeperWatcher.realeaseConnect();
        }
    }
}
