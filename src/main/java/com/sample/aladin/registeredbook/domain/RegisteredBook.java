package com.sample.aladin.registeredbook.domain;

import com.sample.aladin.book.domain.Book;
import com.sample.aladin.enrollment.domain.UnitAmount;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RegisteredBook {

    private Long id;
    private Book book;
    private UnitAmount amount; //금액

    public RegisteredBook(Book book, UnitAmount amount) {
        this.id = UUID.randomUUID().getMostSignificantBits();
        this.book = book;
        this.amount = amount;
    }

    public boolean equalsBook(RegisteredBook registeredBook) {
        return this.id.equals(registeredBook.id);
    }
}
