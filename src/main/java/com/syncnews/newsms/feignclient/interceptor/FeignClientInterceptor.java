package com.syncnews.newsms.feignclient.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

@Component
public class FeignClientInterceptor implements RequestInterceptor {

    private static final String AUTHORIZATION_HEADER = "X-API-KEY";

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header(AUTHORIZATION_HEADER, String.format("%s", "301bad4dba79dbadbf1c1bc0eb3cc947b18ba78f"));
    }
}
