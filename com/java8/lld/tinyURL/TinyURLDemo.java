package com.java8.lld.tinyURL;

import com.java8.lld.tinyURL.repository.InMemoryUrlRepository;
import com.java8.lld.tinyURL.repository.UrlRepository;
import com.java8.lld.tinyURL.service.UrlRedirectionService;
import com.java8.lld.tinyURL.service.UrlShorteningService;
import com.java8.lld.tinyURL.strategy.Base62CounterGenerator;
import com.java8.lld.tinyURL.strategy.ShortCodeGenerator;

/*
main method to orchestrate tiny url demo
 */
public class TinyURLDemo {
    public static void main(String[] args) {
        UrlRepository urlRepository = new InMemoryUrlRepository();
        ShortCodeGenerator shortCodeGenerator = new Base62CounterGenerator();

        UrlShorteningService urlShorteningService = new UrlShorteningService(urlRepository, shortCodeGenerator);
        UrlRedirectionService urlRedirectionService = new UrlRedirectionService(urlRepository);

        String code1 = urlShorteningService.shorten("https://google.com", 3600000); // 1hour
        String code2 = urlShorteningService.shorten("https://github.com", 600000); // 10mins

        System.out.println("Shortened " + "https://google.com to: /" + code1);
        System.out.println("Shortened " + "https://github.com to: /" + code2);

        String url = urlRedirectionService.resolve(code1);
        String url2 = urlRedirectionService.resolve(code2);
        System.out.println("Resolving /" + code1 + ": Original URL - " + url);
        System.out.println("Resolving /" + code2 + ": Original URL - " + url2);

        String code3 = urlShorteningService.shorten("https://amazon.com", 1000); // 1s
        System.out.println("Shortened " + "https://amazon.com to: /" + code3);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        System.out.println("Resolving /"  + code3 + " after expiry: " + urlRedirectionService.resolve(code3));
    }
}
