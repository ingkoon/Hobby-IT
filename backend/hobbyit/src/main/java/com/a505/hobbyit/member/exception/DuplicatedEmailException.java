package com.a505.hobbyit.member.exception;

public class DuplicatedEmailException extends RuntimeException{
    public DuplicatedEmailException(String message) {
        super(message);
    }

    public DuplicatedEmailException() {
        this("중복된 이메일입니다.");
    }























}
