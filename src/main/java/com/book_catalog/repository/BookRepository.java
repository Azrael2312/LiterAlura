package com.book_catalog.repository;

import com.book_catalog.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    // Additional custom queries can be added here
}
