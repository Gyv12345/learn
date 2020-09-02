package cn.yt4j.httpclient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws Exception {
        int corePoolSize = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, corePoolSize + 1, 10L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100));

        int skillNum = 100;
        final CountDownLatch latch = new CountDownLatch(skillNum);//N个抢红包

        for (int i = 0; i < 100; i++) {
            Runnable task = () -> {
                CloseableHttpClient httpClient = null;
                CloseableHttpResponse response = null;
                try {
                    httpClient = HttpClientBuilder.create().build();
                    HttpUriRequest request = new HttpGet("http://localhost:8080");
                    response = httpClient.execute(request);
                    int code = response.getStatusLine().getStatusCode();
                    System.out.println(code);
                    latch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (httpClient != null) {
                        try {
                            httpClient.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            executor.execute(task);
        }

        latch.await();
        System.out.println("完");
        System.exit(0);
    }
}
