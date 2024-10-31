package com.syncnews.newsms.usecase.news.mapper;

import com.syncnews.newsms.controller.news.request.NewsFilterRequest;
import com.syncnews.newsms.controller.news.response.NewsResponse;
import com.syncnews.newsms.feignclient.serper.request.NewsFilterFeignRequest;
import com.syncnews.newsms.feignclient.serper.response.NewsFeignResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GetNewsUseCaseMapper {


    @Mapping(target = "type", constant = "news")
    @Mapping(target = "engine", constant = "google")
    @Mapping(target = "q", source = "query")
    @Mapping(target = "gl", constant = "br")
    @Mapping(target = "hl", constant = "pt-br")
    @Mapping(target = "page", source = "page")
    NewsFilterFeignRequest mappingNewsFilterFeignRequestBy(final NewsFilterRequest request);

    NewsResponse mappingNewsResponseBy(final NewsFeignResponse newsFeignResponse);
}
