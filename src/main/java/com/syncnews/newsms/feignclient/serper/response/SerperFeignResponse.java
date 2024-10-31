package com.syncnews.newsms.feignclient.serper.response;

import java.util.List;

public record SerperFeignResponse(SearchParametersFeignResponse searchParameters,
                                  List<NewsFeignResponse> news,
                                  Integer credits
) {
}
