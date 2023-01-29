package com.a505.hobbyit.hobbymember.exception;

public class UnAuthorizedHobbyException extends RuntimeException{
    public UnAuthorizedHobbyException(final String message) {
        super(message);
    }

    public UnAuthorizedHobbyException() {
        this("접근 권한이 없습니다.");
    }
}
