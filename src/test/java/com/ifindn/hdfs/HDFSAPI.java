package com.ifindn.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import sun.applet.Main;

import javax.sound.midi.SoundbankResource;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author Guo Yan
 * @date 2020/3/18-20:13
 */
public class HDFSAPI {



    private static final Logger logger = LogManager.getLogger(HDFSAPI.class);

    private Configuration conf ;
    private FileSystem fs;

    @Before
    public void getConfig(){
        conf = new Configuration();
    }

    @Test
    public void initHDFS() throws IOException {
        //创建配置信息
        //ctrl + alt + v,后推前
        Configuration conf = new Configuration();

        //获取文件系统
        FileSystem fs = FileSystem.get(conf);

        //打印文件系统
        System.out.println(fs.toString());

    }

    @Test
    public void putFile() throws URISyntaxException, IOException, InterruptedException {

        //创建配置信息
        Configuration conf = new Configuration();

        //设置临时参数
        conf.set("dfs.replication","2");

        //获取文件系统
        FileSystem fs = FileSystem.get(new URI("hdfs://bigdata10:9000"),conf,"root");

        //windows文件上传路径
        Path input = new Path("F:\\bigdata0.txt");

        //输出到的路径
        Path output = new Path("hdfs://bigdata10:9000/out/bigdata0.txt");

        //将文件复制到hdfs
        fs.copyFromLocalFile(input,output);

        //关闭流
        fs.close();

        System.out.println("上传成功");
    }


    //下载文件
    @Test
    public void  getHDFS() throws URISyntaxException, IOException, InterruptedException {

        fs = FileSystem.get(new URI("hdfs://bigdata10:9000"),conf,"root");

        /**
         * PARAM:1.是否删除源文件
         *       2.源文件地址
         *       3.目的地址
         *       4.是否进行校验
         */
        fs.copyToLocalFile(false,
                new Path("hdfs://bigdata10:9000/bigdata0.txt"),
                new Path("F:\\c.txt"),
                true);

        fs.close();

        System.out.println("下载成功");
    }

    /**
     * 在HDFS中创建目录/out/aa
     */
    @Test
    public void mkdirHDFS() throws IOException, URISyntaxException, InterruptedException {

        fs = FileSystem.get(new URI("hdfs://bigdata10:9000"),conf,"root");

        fs.mkdirs(new Path("hdfs://bigdata10:9000/out/aa"));

        fs.close();

        logger.info("创建成功");
    }

    /**
     * 删除文件，对应 hadoop fs -rmr
     */
    @Test
    public void  deletHDFS() throws URISyntaxException, IOException, InterruptedException {
        fs = FileSystem.get(new URI("hdfs://bigdata10:9000"),conf,"root");

        /**
         * param:1,删除的路径
         *       2.是否递归删除
         */
        fs.delete(new Path("hdfs://bigdata10:9000/out/cc"),true);

        fs.close();

        logger.info("删除成功");
    }

    /**
     * 重命名
     */
    @Test
    public void mvHDFS() throws URISyntaxException, IOException, InterruptedException {

        fs = FileSystem.get(new URI("hdfs://bigdata10:9000"),conf,"root");

        fs.rename(new Path("hdfs://bigdata10:9000/out/bigdata0.txt"),
                new Path("hdfs://bigdata10:9000/out/bigdata10.txt"));
        fs.close();
        logger.info("重命名完成");

    }

    /**
     * 查看文件详细信息
     */
    @Test
    public void readFile() throws IOException, URISyntaxException, InterruptedException {

        fs = FileSystem.get(new URI("hdfs://bigdata10:9000"),conf,"root");

        RemoteIterator<LocatedFileStatus> listFiles = fs.listFiles(new Path("hdfs://bigdata10:9000/"), false);

        while (listFiles.hasNext()){
            LocatedFileStatus ls = listFiles.next();
            System.out.println(ls.getPath().getName());
            System.out.println(ls.getPath());
            System.out.println(ls.getPermission());
            System.out.println(ls.getBlockLocations());
            System.out.println(ls.getBlockSize());

            System.out.println("----------------------");
        }
        System.out.println("*******************************************************");
        FileStatus[] fileStatuses = fs.listStatus(new Path("/out"));
        for(FileStatus status : fileStatuses){
            if(status.isDirectory()){
                System.out.println(status.getPath().getName() + " is directory" );
            }else if(status.isFile()){
                System.out.println(status.getPath().getName() + " is file");
            }else{
                System.out.println("nothing ");
            }

        }
    }
}
