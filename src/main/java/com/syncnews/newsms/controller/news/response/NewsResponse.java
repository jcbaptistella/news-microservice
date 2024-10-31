package com.syncnews.newsms.controller.news.response;

public record NewsResponse(String title,
                           String link,
                           String date,
                           String source,
                           String imageUrl,
                           String position) {
}
