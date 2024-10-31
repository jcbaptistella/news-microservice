package com.syncnews.newsms.service.serper;

import com.syncnews.newsms.feignclient.serper.SerperRestApiClient;
import com.syncnews.newsms.feignclient.serper.request.NewsFilterFeignRequest;
import com.syncnews.newsms.feignclient.serper.response.NewsFeignResponse;
import com.syncnews.newsms.feignclient.serper.response.SerperFeignResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SerperService {

    private final SerperRestApiClient serperRestApiClient;

    public List<NewsFeignResponse> getNewsBy(NewsFilterFeignRequest request) {
        final SerperFeignResponse serperResponse = serperRestApiClient.searchBy(request);

        if (Objects.isNull(serperResponse.news())) {
            throw new RuntimeException("Api fora do ar");
        }

        return serperResponse.news();
    }
}
