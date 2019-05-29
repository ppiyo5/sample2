package com.sample.aladin.buyer.domain;

import com.sample.aladin.common.Address;
import com.sample.aladin.common.Email;
import com.sample.aladin.common.Name;
import com.sample.aladin.common.PhoneNumber;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Buyer {

    private Long id;
    private Name name;
    private PhoneNumber phoneNumber;
    private Email email;
    private Address address;

    public Buyer(String name, String phoneNumber, String email, String address) {
        this.id = UUID.randomUUID().getMostSignificantBits(); //이 UUID 의 128 비트치의 최상정도 64 비트를 돌려줍니다.
        this.name = new Name(name);
        this.phoneNumber = new PhoneNumber(phoneNumber);
        this.email = new Email(email);
        this.address = new Address(address);
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

    public Address getAddress() {
        return address;
    }
}
