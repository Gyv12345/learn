package cn.yt4j.spi;

import java.util.ServiceLoader;

public class Test {
    public static void main(String[] args) {
        ServiceLoader<IRepository> serviceLoader = ServiceLoader.load(IRepository.class);
        serviceLoader.forEach(IRepository::save);
    }
}
