package com.sample.aladin.book.application;

import com.sample.aladin.book.domain.Book;
import com.sample.aladin.book.domain.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class BookService {
    final private BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public boolean isExist(Long id) {
        return !ObjectUtils.isEmpty(getBook(id));
    }

    private Book getBook(Long id) {
        return repository.findById(id)
                .orElseThrow(IllegalAccessError::new);
    }
}
