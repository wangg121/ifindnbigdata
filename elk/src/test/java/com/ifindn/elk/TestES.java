package com.ifindn.elk;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.get.MultiGetItemResponse;
import org.elasticsearch.action.get.MultiGetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * @author Guo Yan
 * @date 2020/5/19-12:11
 */
public class TestES {

    private TransportClient client;

    @BeforeEach
    public void getClient() throws UnknownHostException {
        Settings settings = Settings.builder().put("cluster.name","ES-cluster10").build();
        client = new PreBuiltTransportClient(settings);
        client.addTransportAddress(new TransportAddress(InetAddress.getByName("192.168.189.10"),9300));
    }

    //创建索引
    @Test
    public void createIndex_blog2(){
        client.admin().indices().prepareCreate("blog3").get();

        client.close();
    }

    //删除索引
    @Test
    public void deleteIndex(){
        System.out.println("删除数据");
        client.admin().indices().prepareDelete("blog").get();
        client.close();
    }

    //使用json 创建document
    //上面的例子是对index和type做操作，所以需要admin（）,对document做操作时，就不需要admin（）；
    @Test
    public void createIndexDataByJson(){

        //创建文档
        IndexResponse response = client.prepareIndex("blog2","article","2")
                .setSource("name","2").execute().actionGet();

        //打印信息
        System.out.println("索引为 " + response.getIndex());
        System.out.println("表为 " + response.getType());
        System.out.println("id为 " + response.getId());
        System.out.println("版本为 " + response.getVersion());
        System.out.println("结果为 " + response.getResult());

        //关闭连接
        client.close();
    }

    //使用map存数据，常用
    @Test
    public void creatIndexDataByMap(){
        Map<String,String> json = new HashMap<>();
        json.put("name","lisi");

        IndexResponse response = client.prepareIndex("blog3","article","2")
                .setSource(json).execute().actionGet();

        //打印信息
        System.out.println("索引为 " + response.getIndex());
        System.out.println("表为 " + response.getType());
        System.out.println("id为 " + response.getId());
        System.out.println("版本为 " + response.getVersion());
        System.out.println("结果为 " + response.getResult());

        //关闭连接
        client.close();
    }

    //使用XContextBuilder存数据,常用
    @Test
    public void createIndexDataByXContextBuilder() throws IOException {

        XContentBuilder builder = XContentFactory.jsonBuilder()
                .startObject()
                .field("name","wangwu")
                .endObject();


        IndexResponse response = client.prepareIndex("blog2","article","1").setSource(builder)
                .execute().actionGet();

        System.out.println("索引为 " + response.getIndex());
        System.out.println("type为 " + response.getType());
        System.out.println("id为 " + response.getId());
        System.out.println("结果为 " + response.getResult());

        client.close();

    }

    //获取一个文档，不常用
    @Test
    public void getDoc(){
        GetResponse response = client.prepareGet("blog2","article","1").get();
        System.out.println(response.getSourceAsString());
        client.close();
    }

    //获取多个文档，不常用
    @Test
    public void getMutilDoc(){
        MultiGetResponse responses = client.prepareMultiGet()
                .add("blog2","article","1")
                .add("blog3","article","2")
                .add("blog2","article","1","2")
                .get();

        for (MultiGetItemResponse itemResponse:responses){
            GetResponse getResponse = itemResponse.getResponse();
            if(getResponse.isExists()){
                System.out.println(getResponse.getSourceAsString());
            }
        }


    }

    //更新
    @Test
    public void updateDoc() throws IOException, ExecutionException, InterruptedException {
        UpdateRequest request = new UpdateRequest("blog2","article","1");
        request.doc(
                XContentFactory.jsonBuilder().startObject()
                .field("age",20)
                .endObject()
        );

        UpdateResponse response  = client.update(request).get();

        //打印结果

        System.out.println("版本" + response.getVersion());
        System.out.println("结果" + response.getResult());

        client.close();


    }

    //插入更新
    @Test
    public void upInsert() throws IOException, ExecutionException, InterruptedException {
        IndexRequest indexRequest = new IndexRequest("blog2","article","5");
        indexRequest.source(XContentFactory.jsonBuilder().startObject()
            .field("tall","186")
            .field("age","20")
            .endObject());

        UpdateRequest updateRequest = new UpdateRequest("blog2","article","5");
        updateRequest.doc(XContentFactory.jsonBuilder().startObject()
            .field("user","李四")
            .endObject()).upsert(indexRequest);

        client.update(updateRequest).get();

        client.close();

    }

    @Test
    public void deleteDoc(){
        DeleteResponse response = client.prepareDelete("blog2","article","5").get();

        System.out.println(response.getIndex());
        System.out.println(response.getType());
        System.out.println(response.getIndex());
        System.out.println(response.getResult());
        System.out.println(response.getVersion());
        System.out.println("end");
    }

}
