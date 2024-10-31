package com.syncnews.newsms.usecase.news;

import com.syncnews.newsms.controller.news.request.NewsFilterRequest;
import com.syncnews.newsms.controller.news.response.NewsResponse;
import com.syncnews.newsms.feignclient.serper.request.NewsFilterFeignRequest;
import com.syncnews.newsms.feignclient.serper.response.NewsFeignResponse;
import com.syncnews.newsms.service.serper.SerperService;
import com.syncnews.newsms.usecase.news.mapper.GetNewsUseCaseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetNewsUseCase {

    private final SerperService serperService;
    private final GetNewsUseCaseMapper mapper;

    public List<NewsResponse> execute(final NewsFilterRequest request) {
        final NewsFilterFeignRequest newsFilterFeignRequest = mapper.mappingNewsFilterFeignRequestBy(request);

        List<NewsFeignResponse> responseList = serperService.getNewsBy(newsFilterFeignRequest);

        return responseList.stream().map(mapper::mappingNewsResponseBy).toList();
    }
}
