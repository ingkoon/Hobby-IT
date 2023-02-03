package com.a505.hobbyit.member.exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException() {
        this("잘못된 요청입니다.");
    }
}
