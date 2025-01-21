package com.book_catalog.service;

import com.book_catalog.model.GutendexBook;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class GutendexService {
    private final RestTemplate restTemplate = new RestTemplate();
    private static final String API_URL = "https://gutendex.com/books";

    public List<GutendexBook> searchBooks(String query) {
        String url = UriComponentsBuilder.fromUriString(API_URL)
                .queryParam("search", query)
                .toUriString();

        GutendexResponse response = restTemplate.getForObject(url, GutendexResponse.class);
        return response != null ? response.getResults() : null;
    }

    // Wrapper class for Gutendex API response
    public static class GutendexResponse {
        private List<GutendexBook> results;

        public List<GutendexBook> getResults() {
            return results;
        }

        public void setResults(List<GutendexBook> results) {
            this.results = results;
        }
    }
}
