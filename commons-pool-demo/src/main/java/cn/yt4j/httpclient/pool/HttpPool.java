package cn.yt4j.httpclient.pool;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.apache.http.client.HttpClient;

public class HttpPool extends GenericObjectPool<HttpClient> {
    public HttpPool(PooledObjectFactory<HttpClient> factory) {
        super(factory);
    }

    public HttpPool(PooledObjectFactory<HttpClient> factory, GenericObjectPoolConfig<HttpClient> config) {
        super(factory, config);
    }
}
