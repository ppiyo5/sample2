package com.sample.aladin.enrollment.domain;

import com.sample.aladin.book.domain.Book;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class EnrollmentTest {

    @Test
    public void 이벤트없이_만원짜리_같은책_세권등록() {
        //given
        Enrollment enrollment = Enrollment.of(1L, new Book(), 3L, 10000L);
        //expect
        assertThat(enrollment.getRegisteredBooks().size()).isEqualTo(3);
        assertThat(enrollment.getEvent().getStartDate()).isNull();
        assertThat(enrollment.getEvent().getEndDate()).isNull();
        assertThat(enrollment.getEvent().getPeriodPercent()).isNull();
        //then
    }

    @Test
    public void 이벤트있는_만원짜리_같은책_세권등록() {
        //given
        Enrollment enrollment = Enrollment.ofWithEvent(1L, new Book(), 3L, 10000L, LocalDate.of(2019, 05, 23), LocalDate.of(2019, 05, 25), 3.0);
        //expect
        assertThat(enrollment.getRegisteredBooks().size()).isEqualTo(3);
        assertThat(enrollment.getEvent().getStartDate()).isEqualTo(LocalDate.of(2019, 05, 23));
        assertThat(enrollment.getEvent().getEndDate()).isEqualTo(LocalDate.of(2019, 05, 25));
        assertThat(enrollment.getEvent().getPeriodPercent()).isEqualTo(3.0);
    }

}