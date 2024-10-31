package com.syncnews.newsms.controller.news;

import com.syncnews.newsms.controller.news.request.NewsFilterRequest;
import com.syncnews.newsms.controller.news.response.NewsResponse;
import com.syncnews.newsms.usecase.news.GetNewsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/news")
public class NewsController {

    private final GetNewsUseCase getNewsUseCase;

    @PostMapping(value = "/search")
    public ResponseEntity<List<NewsResponse>> searchBy(@RequestBody NewsFilterRequest request) {
        List<NewsResponse> response = getNewsUseCase.execute(request);
        return ResponseEntity.ok(response);
    }
}
