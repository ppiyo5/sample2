package com.sample.aladin.book.domain;

import java.util.Optional;

public interface BookRepository {

    Optional<Book> findById(Long id);
}
