package com.thecolinjoe.dubborpcproxy.proxyserver;

import com.thecolinjoe.dubborpcproxy.api.annotation.EnableDubboProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubboProxy
@SpringBootApplication
public class ProxyServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProxyServerApplication.class, args);
    }
}
