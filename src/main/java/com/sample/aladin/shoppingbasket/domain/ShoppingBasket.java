package com.sample.aladin.shoppingbasket.domain;

import com.sample.aladin.enrollment.domain.UnitAmount;
import com.sample.aladin.exception.AlreadyBoundException;
import com.sample.aladin.registeredbook.domain.RegisteredBook;
import com.sample.aladin.registeredbook.domain.ReservationBook;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ShoppingBasket {

    private static final Integer ENABLE_COUNT = 15;

    private Long id;
    private Long buyerId;
    private List<ReservationBook> reservationBooks = new ArrayList<>();

    public void add(RegisteredBook registeredBook) {
        if (reservationBooks.stream().map(ReservationBook::getRegisteredBook) //ReservationBook을 registeredBook으로 매핑
                .anyMatch(registeredBook::equalsBook)) {
            throw new AlreadyBoundException("이미 찜한 책입니다.");
        }

        if(reservationBooks.size() >= ENABLE_COUNT) {
            throw new IllegalStateException("찜한 책의 총합은 15권을 넘지 못합니다.");
        }

        reservationBooks.add(new ReservationBook(this, registeredBook));
    }

    public long getCount() {
        return reservationBooks.size();
    }

    public long getAmount() {
        return reservationBooks.stream()
                .map(ReservationBook::getRegisteredBook)
                .map(RegisteredBook::getAmount)
                .map(UnitAmount::getAmount)
                .reduce(0L, Long::sum);
    }

    public long computeAmount() {
        return deliveryAmount();
    }

    private long deliveryAmount() {
        if(getCount() <= 3) {
            return 2500;
        }

        return 0;
    }
}
