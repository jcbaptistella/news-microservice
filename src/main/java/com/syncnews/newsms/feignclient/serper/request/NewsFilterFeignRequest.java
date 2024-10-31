package com.syncnews.newsms.feignclient.serper.request;

public record NewsFilterFeignRequest(String type,
                                     String engine,
                                     String q,
                                     String gl,
                                     String hl,
                                     Integer page) {
}
