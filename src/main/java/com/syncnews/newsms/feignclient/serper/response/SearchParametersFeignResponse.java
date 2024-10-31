package com.syncnews.newsms.feignclient.serper.response;

public record SearchParametersFeignResponse(String q,
                                            String gl,
                                            String hl,
                                            String type,
                                            String engine) {
}
