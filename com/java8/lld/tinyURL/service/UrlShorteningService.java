package com.java8.lld.tinyURL.service;

import com.java8.lld.tinyURL.entities.ShortenedUrl;
import com.java8.lld.tinyURL.repository.UrlRepository;
import com.java8.lld.tinyURL.strategy.ShortCodeGenerator;

public class UrlShorteningService {
    private UrlRepository repository;
    private ShortCodeGenerator generator;

    public UrlShorteningService(UrlRepository repository, ShortCodeGenerator generator) {
        this.repository = repository;
        this.generator = generator;
    }

    public String shorten(String originalUrl, long ttlMs) {
        String code = generator.generate();
        long expiry = System.currentTimeMillis() + ttlMs;
        ShortenedUrl shortenedUrl = new ShortenedUrl(
                originalUrl,
                code,
                expiry
        );
        repository.save(shortenedUrl);
        return code;
    }
}
