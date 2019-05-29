package com.sample.aladin.book.infra;

import com.sample.aladin.book.domain.Book;
import com.sample.aladin.book.domain.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DummyBookRepository implements BookRepository {

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(DummyBookData.get(id));
    }
}
