package com.java8.lld.tinyURL.repository;

import com.java8.lld.tinyURL.entities.ShortenedUrl;

import java.util.HashMap;
import java.util.Map;

/*
mimics a database using two hashmaps
one map keys URLs to ShortenedUrl objects (for the idempotency checks)
other map keys short codes to ShortenedUrl objects (for the redirect lookups)
 */

public class InMemoryUrlRepository implements UrlRepository {
    private Map<String, ShortenedUrl> urlMap = new HashMap<>();
    private Map<String, ShortenedUrl> codeMap = new HashMap<>();

    @Override
    public ShortenedUrl findByLongUrl(String longUrl) {
        return urlMap.get(longUrl);
    }

    @Override
    public ShortenedUrl findByShortCode(String shortCode) {
        return codeMap.get(shortCode);
    }

    @Override
    public void save(ShortenedUrl shortenedUrl) {
        String shortCode = shortenedUrl.getShortCode();
        String longUrl = shortenedUrl.getLongUrl();

        // Check if this shortCode is already in the map
        if (codeMap.containsKey(shortCode)) {
            // It exists! Get the existing mapping
            ShortenedUrl existingMapping = codeMap.get(shortCode);
            String existingLongUrl = existingMapping.getLongUrl();

            // Compare: is the existing longUrl the SAME as what we're trying to save?
            if (!existingLongUrl.equals(longUrl)) {
                // COLLISION! Different URLs, same shortCode
                throw new IllegalArgumentException(
                        "Collision detected: shortCode '" + shortCode +
                                "' already maps to '" + existingLongUrl +
                                "', cannot map to '" + longUrl + "'"
                );
            }
            // If they're the SAME, we just continue and overwrite (idempotency)
        }

        codeMap.put(shortCode, shortenedUrl);
        urlMap.put(longUrl, shortenedUrl);
    }
}
