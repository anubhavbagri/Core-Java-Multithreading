package com.java8.lld.tinyURL.entities;

// Builder pattern might be applicable

public class ShortenedUrl {
    private String longUrl;
    private String shortCode;
    private long expiresAtMs;

    public ShortenedUrl(String longUrl, String shortCode, long expiresAtMs) {
        this.longUrl = longUrl;
        this.shortCode = shortCode;
        this.expiresAtMs = expiresAtMs;
    }

    public boolean isExpired(){
        return System.currentTimeMillis() > expiresAtMs;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public String getShortCode() {
        return shortCode;
    }
}
