package com.sample.aladin.seller.domain;

import com.sample.aladin.common.Email;
import com.sample.aladin.common.Name;
import com.sample.aladin.common.PhoneNumber;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Seller {

    private Long id;
    private Name name;
    private PhoneNumber phoneNumber;
    private Email email;

    public Seller(String name, String phoneNumber, String email) {
        this.id = UUID.randomUUID().getMostSignificantBits();
        this.name = new Name(name);
        this.phoneNumber = new PhoneNumber(phoneNumber);
        this.email = new Email(email);
    }

    public Name getName() {
        return name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public Email getEmail() {
        return email;
    }
}
