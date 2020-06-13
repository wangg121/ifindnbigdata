package com.ifindn.elk;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.get.MultiGetItemResponse;
import org.elasticsearch.action.get.MultiGetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
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
 * @date 2020/5/20-9:08
 */
public class TestEs2 {

    private TransportClient client;

    @BeforeEach
    public void getClient() throws UnknownHostException {
        Settings settings = Settings.builder().put("cluster.name","ES-cluster10").build();

        client = new PreBuiltTransportClient(settings);

        client.addTransportAddress(new TransportAddress(InetAddress.getByName("192.168.189.10"),9300));

    }

    //创建索引
    @Test
    public void createIndex(){
        client.admin().indices().prepareCreate("test1").get();
        client.admin().indices().prepareCreate("test2").get();

        client.close();
    }

    //删除索引
    @Test
    public void deleteIndex(){
        client.admin().indices().prepareDelete("test2").get();
        client.close();
    }

    @Test
    public void createDocbyMap(){
        Map<String,String> data = new HashMap<>();
        data.put("class","english");
        data.put("book","java");

        IndexResponse response = client.prepareIndex("test3","edu","1")
                .setSource(data).get();

        System.out.println(response.getIndex());
        System.out.println(response.getType());
        System.out.println(response.getVersion());
        System.out.println(response.getResult());

        client.close();
    }

    @Test
    public void createDocByXContentBuilder() throws IOException {
        XContentBuilder builder = XContentFactory.jsonBuilder()
                .startObject()
                .field("name","jack")
                .field("age","23")
                .endObject();

        IndexResponse response = client.prepareIndex("test5","work","1").setSource(builder).get();


        System.out.println(response.getIndex());
        System.out.println(response.getType());
        System.out.println(response.getVersion());
        System.out.println(response.getResult());

        client.close();
    }

    @Test
    public void getDoc(){

        GetResponse response = client.prepareGet("test5","work","1").get();
        System.out.println(response.getIndex());
        System.out.println(response.getType());
        System.out.println(response.getVersion());
        System.out.println(response.getSourceAsString());

        client.close();
    }

    @Test
    public void getMultDoc(){
        MultiGetResponse response = client.prepareMultiGet()
                .add("blog2","article","1")
                .add("blog2","article","2")
                .get();

        for(MultiGetItemResponse itemResponse:response){
            GetResponse getResponse = itemResponse.getResponse();
            if(getResponse.isExists()){
                System.out.println(getResponse.getSourceAsString());
            }
        }
    }

    @Test
    public void updateDoc() throws IOException, ExecutionException, InterruptedException {
        UpdateRequest request = new UpdateRequest("test5","work","1");
        request.doc(XContentFactory.jsonBuilder().startObject()
        .field("name","马云").endObject());
        client.update(request).get();
        client.close();
    }







}
