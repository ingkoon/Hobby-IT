package com.a505.hobbyit.article.exception;

public class UnAuthorizedArticleException extends RuntimeException {

    public UnAuthorizedArticleException(String message) {
        super(message);
    }
}
