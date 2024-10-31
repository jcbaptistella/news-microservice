package com.syncnews.newsms.feignclient.serper.response;

public record NewsFeignResponse(String title,
                                String link,
                                String date,
                                String source,
                                String imageUrl,
                                String position) {
}
