package com.jnshu.until;

import com.jnshu.config.MecacheConfig;
import net.spy.memcached.MemcachedClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.InetSocketAddress;

@Component
public class MemcacheUtil implements CommandLineRunner {
    @Resource
    private MecacheConfig mecacheConfig;
    private MemcachedClient client = null;
    @Override
    public void run(String... args) throws Exception {
        try {
            client = new MemcachedClient(new InetSocketAddress(mecacheConfig.getIp(),mecacheConfig.getPort()));
        } catch (IOException e) {
            System.out.println("MemcachedClient初始化失败");
        }
    }

    public MemcachedClient getClient() {
        return client;
    }
}