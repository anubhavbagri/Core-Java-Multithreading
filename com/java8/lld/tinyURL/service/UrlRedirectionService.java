package com.java8.lld.tinyURL.service;

import com.java8.lld.tinyURL.entities.ShortenedUrl;
import com.java8.lld.tinyURL.repository.UrlRepository;

public class UrlRedirectionService {
    private UrlRepository repository;

    public UrlRedirectionService(UrlRepository repository) {
        this.repository = repository;
    }

    // Simple retrieval + expiry check

    public String resolve(String shortCode) {
        ShortenedUrl shortenedUrl = repository.findByShortCode(shortCode);

        if ((shortenedUrl != null) && !shortenedUrl.isExpired()) {
            return shortenedUrl.getLongUrl();
        }
        return null;
    }
}
