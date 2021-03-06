package com.thecolinjoe.dubborpcproxy.api.request;

import lombok.Data;

/*
 * Description: 调用对象
 *
 * @author: jipengfei
 * @date: 2020/12/24 19:57
 */
@Data
public class ProxyRequest {

    /**
     * 参数类型
     */
    private String[] paramTypes;

    /**
     * 参数列表
     */
    private Object[] params;

    /**
     * 指定访问主机
     */
    private String hostName;
}
