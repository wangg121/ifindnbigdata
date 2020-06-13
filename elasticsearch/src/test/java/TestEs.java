import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Before;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Guo Yan
 * @date 2020/5/19-10:37
 */
public class TestEs {


    private TransportClient client;

    @Before
    public  void getClient() throws UnknownHostException {
        Settings settings = Settings.builder().put("cluster.name","ES-cluster10").build();

        client = new PreBuiltTransportClient(settings);

        client.addTransportAddress(new TransportAddress(InetAddress.getByName("192.168.189.10"),9300));
    }

    @Test
    public void  creatIndex_blog(){
        System.out.println("写入开始");
        client.admin().indices().prepareCreate("blog").get();
        client.close();
        System.out.println("写入完毕");
    }

}
