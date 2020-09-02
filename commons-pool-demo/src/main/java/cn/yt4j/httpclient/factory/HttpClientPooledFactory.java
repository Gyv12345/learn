package cn.yt4j.httpclient.factory;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpClientPooledFactory implements PooledObjectFactory<CloseableHttpClient> {

    @Override
    public PooledObject<CloseableHttpClient> makeObject() throws Exception {
        return new DefaultPooledObject<>(HttpClientBuilder.create().build());
    }

    @Override
    public void destroyObject(PooledObject<CloseableHttpClient> p) throws Exception {
        p.getObject().close();
    }

    @Override
    public boolean validateObject(PooledObject<CloseableHttpClient> p) {
        return p.getObject() != null;
    }

    @Override
    public void activateObject(PooledObject<CloseableHttpClient> p) throws Exception {
        CloseableHttpClient httpClient=HttpClientBuilder.create().build();
        p=new DefaultPooledObject<>(httpClient);
    }

    @Override
    public void passivateObject(PooledObject<CloseableHttpClient> p) throws Exception {

    }
}
