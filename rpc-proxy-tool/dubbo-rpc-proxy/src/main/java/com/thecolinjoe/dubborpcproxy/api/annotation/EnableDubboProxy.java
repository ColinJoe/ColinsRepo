package com.thecolinjoe.dubborpcproxy.api.annotation;

import com.thecolinjoe.dubborpcproxy.api.configuration.EnableDubboProxyImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Import(EnableDubboProxyImportSelector.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableDubboProxy {
}
