package com.thecolinjoe.dubborpcproxy.api;

import com.thecolinjoe.dubborpcproxy.api.exception.DubboRpcProxyException;
import com.thecolinjoe.dubborpcproxy.api.properties.ProxyProperties;
import com.thecolinjoe.dubborpcproxy.api.request.ProxyRequest;
import com.thecolinjoe.rpcproxy.common.response.impl.SuccessResponse;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
 * Description: dubbo rpc 代理请求接口
 *
 * @author: jipengfei
 * @date: 2020/12/24 19:42
 */
@RestController
@RequestMapping("/dubbo-rpc")
public class DubboRpcProxyApi {

    @Autowired
    private ProxyProperties proxyProperties;

    /**
     * dubbo-rpc 代理请求
     *
     * @param request
     * @param group
     * @param version
     * @param methodName
     */
    @PostMapping("/{group}/{version}/{methodName}")
    public SuccessResponse proxy(@RequestBody ProxyRequest request
            , @PathVariable("group") String group
            , @PathVariable("version") String version
            , @PathVariable("methodName") String methodName) {

        try {
            Object[] params = request.getParams();
            String[] paramTypes = request.getParamTypes();
            if (params.length != paramTypes.length) {
                throw new RuntimeException("参数类型与参数个数不一致!");
            }

            int of = methodName.lastIndexOf(".");
            String interfaceS = methodName.substring(0, of);
            String method = methodName.substring(of + 1);

            ReferenceConfig<GenericService> reference = new ReferenceConfig<>();
            DubboBootstrap dubboBootstrap = DubboBootstrap.getInstance();
            dubboBootstrap.application(proxyProperties.getAppName());
            reference.setBootstrap(dubboBootstrap);

            reference.setUrl(request.getHostName());

            reference.setTimeout(proxyProperties.getDubboRpcTimeOut());

            reference.setInterface(interfaceS);
            reference.setVersion(version);
            reference.setGeneric("true");
            reference.setGroup(group);

            RegistryConfig registry = new RegistryConfig();
            registry.setAddress("zookeeper://" + proxyProperties.getZkAddress());
            reference.setRegistry(registry);

            GenericService genericService = reference.get();
            Object o = genericService.$invoke(method, request.getParamTypes(), request.getParams());
            return new SuccessResponse<>(o);
        } catch (Exception e) {

            throw new DubboRpcProxyException(e);
        }
    }
}
