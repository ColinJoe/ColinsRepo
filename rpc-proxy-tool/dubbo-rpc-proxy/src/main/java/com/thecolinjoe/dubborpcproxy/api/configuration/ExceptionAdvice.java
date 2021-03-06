package com.thecolinjoe.dubborpcproxy.api.configuration;

import com.thecolinjoe.dubborpcproxy.api.exception.DubboRpcProxyException;
import com.thecolinjoe.rpcproxy.common.response.Response;
import com.thecolinjoe.rpcproxy.common.response.impl.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(DubboRpcProxyException.class)
    @ResponseBody
    public Response handleIndexOutOfBoundsException(DubboRpcProxyException e) {
        return new ErrorResponse(e.getMessage());
    }
}
