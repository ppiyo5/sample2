package com.sample.aladin.academy.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sample.aladin.academy.domain.Academy;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.sample.aladin.academy.domain.QAcademy.academy;

@RequiredArgsConstructor
public class AcademyRepositoryImpl implements AcademyRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Academy> findByName(String name) {
        return queryFactory
                .selectFrom(academy)
                .where(academy.name.eq(name))
                .fetch();
    }
}
