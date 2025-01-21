package com.book_catalog.controller;

import com.book_catalog.model.GutendexBook;
import com.book_catalog.service.GutendexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gutendex")
public class GutendexController {
    @Autowired
    private GutendexService gutendexService;

    @GetMapping("/search")
    public List<GutendexBook> searchBooks(@RequestParam String query) {
        return gutendexService.searchBooks(query);
    }
}
