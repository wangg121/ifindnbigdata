package com.ifindn.elk;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Guo Yan
 * @date 2020/5/20-10:36
 */
@TestPropertySource("classpath:es.properties")
@SpringBootTest
public class EsQuery {

    private TransportClient client;

    @Value("${es.clustername}")
    private String cluserterName;

    @Value(("${es.port}"))
    private Integer port;

    @Value(("${es.host}"))
    private String host;


    @BeforeEach
    public void getClient() throws UnknownHostException {
        Settings settings = Settings.builder().put("cluster.name",cluserterName).build();
        client = new PreBuiltTransportClient(settings);
        client.addTransportAddress(new TransportAddress(InetAddress.getByName(host),port));
    }


    //全部匹配
    @Test
    public void matchAllQuery(){

        SearchResponse response = client.prepareSearch("blog2")
                                  .setTypes("article")
                                  .setQuery(QueryBuilders.matchAllQuery()).get();

        SearchHits hits = response.getHits();

        System.out.println("查询结果：" + hits.totalHits);

        for (SearchHit hit:hits){
            System.out.println(hit.getSourceAsString());
        }
        client.close();
    }


    //条件查询，类似于like，不用加字段，对所有的字段都like,按照切词的字段like
    @Test
    public void query(){

        SearchResponse response = client.prepareSearch("blog2")
                .setTypes("article").setQuery(QueryBuilders.queryStringQuery("wangwu")).get();

        printInfo(response);

    }

    //通配符查询，需要指定字段，通配符在mysql中为%%,在es中为**
    @Test
    public void wildcardQuery(){
        SearchResponse response = client.prepareSearch("blog2")
                .setTypes("article").setQuery(QueryBuilders.wildcardQuery("name","*wa*")).get();
        printInfo(response);
    }


    //分词精确查询，查询name 分词后包含wangwu的blog2的文档，用的比较多
    @Test
    public void termQuery(){
        SearchResponse response = client.prepareSearch("blog2")
                .setTypes("article").setQuery(QueryBuilders.termQuery("name","wangwu")).get();

        printInfo(response);
    }

    //fuzzy query 分词模糊查询，通过增加fuzziness 模糊属性
    @Test
    public void fuzzyQuery(){
        SearchResponse response = client.prepareSearch("blog2")
                .setTypes("article").setQuery(QueryBuilders.fuzzyQuery("name","wangwu"))
                .get();

        printInfo(response);
    }








    public void  printInfo(SearchResponse response){
        SearchHits hits = response.getHits();
        System.out.println("结果数量为：" + hits.totalHits);
        for(SearchHit hit : hits){
            System.out.println("返回结果为：" + hit.getSourceAsString());
        }
    }

}
