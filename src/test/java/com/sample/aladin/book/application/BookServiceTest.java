package com.sample.aladin.book.application;

import com.sample.aladin.book.domain.Book;
import com.sample.aladin.book.domain.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

    @Mock
    private BookRepository repository;

    @InjectMocks
    private BookService service;

    @Test
    public void 책이_있나요() {
        //given
        given(repository.findById(any()))
                .willReturn(
                        Optional.of(
                                new Book("이펙티브 자바", "조슈아 블로크", "IT서적", "개앞맵시")
                        )
                )
        ;

        //when
        boolean isExist = service.isExist(2L);
        //then
        assertThat(isExist).isTrue();
    }

}