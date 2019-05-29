package com.sample.aladin.common;

import com.sample.aladin.exception.NotFoundException;
import com.sample.aladin.exception.WrongValueException;
import org.junit.Test;

public class EmailTest {

    @Test(expected = NotFoundException.class)
    public void 비정상적인_이메일() {
        //given
        Email email = new Email("");
    }

    @Test(expected = WrongValueException.class)
    public void 비정상적인_이메일_ㄱㄴㄷㄹ() {
        //given
        Email email = new Email("ㄱㄴㄷㄹ");
    }

    @Test
    public void 정상적인_이메일() {
        //given
        Email email = new Email("aaa@aaa.com");
    }

}