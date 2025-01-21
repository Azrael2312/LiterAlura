package com.book_catalog.controller;

import com.book_catalog.model.Book;
import com.book_catalog.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public Book saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }
}