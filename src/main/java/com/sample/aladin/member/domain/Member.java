package com.sample.aladin.member.domain;

import com.sample.aladin.common.Email;
import com.sample.aladin.common.Name;
import com.sample.aladin.common.PhoneNumber;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "member")
@ToString
public class Member {

    @Id
    private String id; //멤버아이디
    private String password; //비밀번호
    private String gender; //성별
    private String enabled="1"; //탈퇴여부
    private int part=0; //참여횟수

    @Embedded
    private Name name; //이름

    @Embedded
    private PhoneNumber phoneNumber; //전화번호

    @Embedded
    private Email email; //이메일

    @CreationTimestamp
    private Timestamp createDate;

    @UpdateTimestamp
    private Timestamp updateDate;

    public Member(String id, String password, String gender, String enabled, int part, String name, String phoneNumber, String email) {
        this.id = id;
        this.password = password;
        this.gender = gender;
        this.enabled = enabled;
        this.part = part;
        this.name = new Name(name);
        this.phoneNumber = new PhoneNumber(phoneNumber);
        this.email = new Email(email);
    }

    //정적 팩토리메서드
    public static Member of(String id, String password, String gender, String enabled, int part, String name, String phoneNumber, String email) {
        return new Member(id, password, gender, enabled, part, name, phoneNumber, email);
    }

    //    @OneToMany


}
