package com.sample.aladin.book.domain;

import com.sample.aladin.exception.NotFoundException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

//책 저자 도메인
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) //파라미터가 없는 생성자를 만들어준다. (접근제한자 설정)
public class Author {

    private String author;

    public Author(String author) {
        this.author = validation(author);
    }

    private String validation(String author) {
        if(StringUtils.isEmpty(author)) {
            throw new NotFoundException("저자정보가 없습니다.");
        }
        return author;
    }
}
