package com.thecolinjoe.rpcproxy.common.response.impl;

import com.thecolinjoe.rpcproxy.common.response.Response;

public class ErrorResponse extends Response {

    public ErrorResponse(Throwable throwable) {
        super(ERROR_CODE, throwable.getMessage(), throwable);
    }

    public ErrorResponse(String detailMessage) {
        super(ERROR_CODE, detailMessage, null);
    }
}
