package com.sample.aladin.common;

import com.sample.aladin.exception.NotFoundException;
import org.junit.Test;

public class AddressTest {

    @Test(expected = NotFoundException.class)
    public void 비정상적인_주소() {
        //given
        Address address = new Address("");
    }

    @Test
    public void 정상적인_주소_서울시() {
        //given
        Address address = new Address("서울시");
    }

}