package com.sample.aladin.member.repository;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.JPQLQuery;
import com.sample.aladin.member.domain.Member;
import com.sample.aladin.member.domain.QMember;
import lombok.extern.java.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Log
public class MemberRepositoryImpl extends QuerydslRepositorySupport implements CustomWebBoard {

    public MemberRepositoryImpl() {
        super(QMember.class);
    }

    @Override
    public Page<Object[]> getCustomPage(String type, String keyword, Pageable page) {
//        log.info("====================================");
//        log.info("TYPE: " + type);
//        log.info("KEYWORD: " + keyword);
//        log.info("PAGE: " + page);
//        log.info("======================= =============");

        QMember m = QMember.member;

        JPQLQuery<Member> query = from(m);
        JPQLQuery<Tuple> tuple = query.select(m.id, m.name.name, m.password, m.gender, m.phoneNumber.phoneNumber, m.email.email, m.part, m.enabled);

        tuple.where(m.id.isNotNull());

        if(type != null) {
            switch (type.toLowerCase()) {
                case "i":
                    tuple.where(m.id.like("%" + keyword + "%"));
                    break;
                case "n":
                    tuple.where(m.name.name.like("%" + keyword + "%"));
                    break;
            }
        }

        tuple.groupBy(m.id);
        tuple.orderBy(m.createDate.desc());

        tuple.offset(page.getOffset());
        tuple.limit(page.getPageSize());

        List<Tuple> list = tuple.fetch();

//        log.info("list: "+list);

        List<Object[]> resultList = new ArrayList<>();

        list.forEach(t -> {
            resultList.add(t.toArray());
        });

        long total = tuple.fetchCount();

        return new PageImpl<>(resultList, page, total);
    }

    @Override
    public Long getCustomPageCount(String type, String keyword, Pageable pageable) {

        QMember m = QMember.member;

        JPQLQuery<Member> query = from(m);
        JPQLQuery<String> tuple = query.select(m.id);

        if(type != null) {

            switch (type.toLowerCase()) {
                case "i":
                    tuple.where(m.id.like("%" + keyword + "%"));
                    break;
                case "n":
                    tuple.where(m.name.name.like("%" + keyword + "%"));
                    break;
            }
        }

        long total = tuple.fetchCount();

        return total;
    }
}
