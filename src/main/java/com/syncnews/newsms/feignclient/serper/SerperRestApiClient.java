package com.syncnews.newsms.feignclient.serper;

import com.syncnews.newsms.feignclient.interceptor.FeignClientInterceptor;
import com.syncnews.newsms.feignclient.serper.request.NewsFilterFeignRequest;
import com.syncnews.newsms.feignclient.serper.response.SerperFeignResponse;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "serper-rest-api", url = "https://google.serper.dev", configuration = FeignClientInterceptor.class)
@Headers("Content-Type: application/json")
public interface SerperRestApiClient {

    @PostMapping("/news")
    SerperFeignResponse searchBy(@RequestBody final NewsFilterFeignRequest request);
}
