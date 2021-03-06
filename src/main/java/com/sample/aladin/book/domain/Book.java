package com.sample.aladin.book.domain;

import com.sample.aladin.common.Name;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
public class Book {

    private Long id;
    private Name name;
    private Author author;
    private Category category;
    private Publisher publisher;

    public Book(String name, String author, String category, String publisher) {
        this.id = UUID.randomUUID().getMostSignificantBits();
        this.name = new Name(name);
        this.author = new Author(author);
        this.category = new Category(category);
        this.publisher = new Publisher(publisher);
    }
}
