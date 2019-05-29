package com.sample.aladin.book.domain;

import com.sample.aladin.exception.NotFoundException;
import lombok.extern.java.Log;
import org.junit.Test;

@Log
public class PublisherTest {

    @Test(expected = NotFoundException.class)
    public void 비정상적인_출판사_생성() {
        //given
        Publisher publisher = new Publisher("");
    }

    @Test
    public void 정상적인_출판사_생성() {
        //given
        Publisher publisher = new Publisher("한빛미디어");
        log.info("publisher:"+publisher.getPublisher());
    }

}