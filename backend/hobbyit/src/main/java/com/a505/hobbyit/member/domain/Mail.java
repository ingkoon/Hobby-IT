package com.a505.hobbyit.member.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Mail {
    private String address;
    private String title;
    private String message;

    public Mail(String address, String title, String message) {
        this.address = address;
        this.title = title;
        this.message = message;
    }
}
