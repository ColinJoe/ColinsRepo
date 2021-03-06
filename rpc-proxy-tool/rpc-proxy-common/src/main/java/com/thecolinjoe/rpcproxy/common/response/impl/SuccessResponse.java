package com.thecolinjoe.rpcproxy.common.response.impl;

import com.thecolinjoe.rpcproxy.common.response.Response;

public class SuccessResponse<T> extends Response {

    public SuccessResponse(T t) {
        super(SUCCESS_CODE, "success", t);
    }
}
