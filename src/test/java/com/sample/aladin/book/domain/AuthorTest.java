package com.sample.aladin.book.domain;

import com.sample.aladin.exception.NotFoundException;
import lombok.extern.java.Log;
import org.junit.Test;

@Log
public class AuthorTest {

    @Test(expected = NotFoundException.class)
    public void 비정상적인_저자_생성() {
        //given
        Author author = new Author("");
    }

    @Test
    public void 정상적인_저자_생성() {
        //given
        Author author = new Author("한소진");
        log.info("auther: "+author.getAuthor() );
    }

}