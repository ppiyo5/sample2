package com.sample.aladin.common;

import com.sample.aladin.exception.NotFoundException;
import com.sample.aladin.exception.WrongValueException;
import lombok.extern.java.Log;
import org.junit.Test;

@Log
public class PhoneNumberTest {

    @Test(expected = NotFoundException.class)
    public void 비정상적인_폰넘버() {
        //given
    PhoneNumber phoneNumber = new PhoneNumber("");

}

    @Test(expected = WrongValueException.class)
    public void 비정상적인_폰넘버_ㄱㄴㄷㄹ() {
        //given
        PhoneNumber phoneNumber = new PhoneNumber("ㄱㄴㄷㄹ");
    }

    @Test
    public void 비정상적인_폰넘버_01012345678() {
        //given
        PhoneNumber phoneNumber = new PhoneNumber("01012345678");
    }

    @Test
    public void 정상적인_폰넘버() {
        //given
        PhoneNumber phoneNumber = new PhoneNumber("010-1234-5678");
    }

}