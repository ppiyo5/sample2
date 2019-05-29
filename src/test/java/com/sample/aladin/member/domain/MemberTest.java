package com.sample.aladin.member.domain;

import com.sample.aladin.member.repository.MemberRepository;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class MemberTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void 멤버_등록() {
        //given
        Member member = Member.of("test", "1234", "여", "1", 0, "테스트", "010-1234-5678", "test@daum.net");
        memberRepository.save(member);
    }

}