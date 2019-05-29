package com.sample.aladin.book.domain;

import com.sample.aladin.exception.NotFoundException;
import lombok.extern.java.Log;
import org.junit.Test;

@Log
public class CategoryTest {

    @Test(expected = NotFoundException.class)
    public void 비정상적인_카테고리_생성() {
        //given
        Category category = new Category("");
    }

    @Test
    public void 정상적인_카테고리_생성() {
        //given
        Category category = new Category("IT");
        log.info("category:" +category.getCategory());
    }

}