package com.sample.aladin.book.domain;

import com.sample.aladin.exception.NotFoundException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

@Getter
@NoArgsConstructor
public class Publisher {

    private String publisher;

    public Publisher(String publisher) {
        this.publisher = validation(publisher);
    }

    public String validation(String publisher) {
        if(StringUtils.isEmpty(publisher)) {
            throw new NotFoundException("출판사 정보가 없습니다.");
        }
        return publisher;
    }
}
