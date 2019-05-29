package com.sample.aladin.common;

import com.sample.aladin.exception.NotFoundException;
import org.junit.Test;

public class NameTest {

    @Test(expected = NotFoundException.class)
    public void 비정상적인_이름() {
        //given
        Name name = new Name("");
    }

    @Test
    public void 정상적인_이름() {
        //given
        Name name = new Name("한소진");
    }

}