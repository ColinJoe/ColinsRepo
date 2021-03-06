package com.thecolinjoe.rpcproxy.common.response;

import lombok.Data;

/*
 * Description: 统一响应接口
 *
 * @author: jipengfei
 * @date: 2020/12/25 16:20
 */
@Data
public abstract class Response<T> {

    protected static final String SUCCESS_CODE = "200";
    protected static final String ERROR_CODE = "500";

    private String code;

    private String message;

    private T data;

    private Throwable throwable;

    public Response(String code, String message, T t) {
        this.code = code;
        this.message = message;
        this.data = t;
    }

    public Response(String code, String message, Throwable throwable) {
        this.code = code;
        this.message = message;
        this.throwable = throwable;
    }
}
