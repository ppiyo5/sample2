package com.sample.aladin.book.ui;

import com.sample.aladin.book.application.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookRestController {
    final private BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/book/{id}")
    public boolean isExist(@PathVariable Long id) {
        return bookService.isExist(id);
    }
}
