package com.book_catalog.model;

import lombok.Data;

import java.util.List;

@Data
public class GutendexBook {
    private String title; // The title of the book
    private List<Author> authors; // List of author objects
    private String language; // The language of the book

    // Corrected getAuthor method to return the first author's name from the list
    public String getAuthor() {
        // Return the name of the first author if the list is not empty, otherwise return "Unknown"
        return (authors != null && !authors.isEmpty()) ? authors.get(0).getName() : "Unknown";
    }

    // Nested class to represent an author
    @Data
    public static class Author {
        private String name; // Author's name
        private Integer birthYear; // Author's birth year
        private Integer deathYear; // Author's death year
    }
}

