package com.sample.aladin.enrollment.domain;

import com.sample.aladin.exception.NotFoundException;
import com.sample.aladin.exception.WrongValueException;
import org.junit.Test;

public class UnitAmountTest {

    @Test(expected = NotFoundException.class)
    public void 비정상적인_금액없음() {
        //given
        UnitAmount unitAmount = new UnitAmount(null);
    }

    @Test(expected = WrongValueException.class)
    public void 비정상적인_금액_minus10000() {
        //given
        UnitAmount unitAmount = new UnitAmount(-10000L);
    }

    @Test
    public void 정상적인_금액() {
        //given
        UnitAmount unitAmount = new UnitAmount(10000L);
    }

}