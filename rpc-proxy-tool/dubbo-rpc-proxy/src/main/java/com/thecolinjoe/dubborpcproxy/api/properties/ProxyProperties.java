package com.thecolinjoe.dubborpcproxy.api.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProxyProperties {

    /**
     * 服务名
     */
    @Value("${spring.application.name:dubbo-rpc-proxy}")
    private String appName;

    /**
     * zk注册地址,zk集群使用逗号拼接
     */
    @Value("${zk.address:127.0.0.1:2181}")
    private String zkAddress;

    /**
     * 调用dubbo服务超时时间(毫秒)
     */
    @Value("${dubbo.rpc.timeout:30000}")
    private Integer dubboRpcTimeOut;
}
