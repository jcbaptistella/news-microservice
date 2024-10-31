package com.syncnews.newsms.controller.news.request;

public record NewsFilterRequest(String query,
                                String country,
                                String language,
                                String dateRange,
                                Integer results,
                                Integer page) {
}
