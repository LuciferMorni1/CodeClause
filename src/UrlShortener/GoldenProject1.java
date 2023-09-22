package UrlShortener;
//--URL SHORTENER--//

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GoldenProject1 {
    private Map<String, String> urlMap;
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int CODE_LENGTH = 6;

    public GoldenProject1() {
        urlMap = new HashMap<>();
    }

    public String shortenUrl(String originalUrl) {
        String shortUrl = generateRandomCode();
        urlMap.put(shortUrl, originalUrl);
        return shortUrl;
    }

    public String getOriginalUrl(String shortUrl) {
        return urlMap.get(shortUrl);
    }

    private String generateRandomCode() {
        Random random = new Random();
        StringBuilder code = new StringBuilder();

        for (int i = 0; i < CODE_LENGTH; i++) {
            code.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }

        return code.toString();
    }

    public static void main(String[] args) {
        GoldenProject1 urlShortener = new GoldenProject1();

        String originalUrl = "http://www.company.com:81/a/b/c.html?user=Alice&year=2008#p2";
        String shortUrl = urlShortener.shortenUrl(originalUrl);
        System.out.println("Shortened URL: " + shortUrl);

        String originalUrlFromShortened = urlShortener.getOriginalUrl(shortUrl);
        System.out.println("Original URL: " + originalUrlFromShortened);
    }
}
