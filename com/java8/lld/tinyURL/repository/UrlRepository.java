package com.java8.lld.tinyURL.repository;

import com.java8.lld.tinyURL.entities.ShortenedUrl;

public interface UrlRepository {
    public ShortenedUrl findByLongUrl(String longUrl);
    public ShortenedUrl findByShortCode(String shortCode);
    public void save(ShortenedUrl shortenedUrl);
}
