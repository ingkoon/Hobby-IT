package com.a505.hobbyit.common.exception;

import com.a505.hobbyit.common.exception.dto.ErrorResponse;
import com.a505.hobbyit.hobby.exception.DuplicatedHobbyException;
import com.a505.hobbyit.hobby.exception.InvalidHobbyException;
import com.a505.hobbyit.hobbymember.exception.UnAuthorizedHobbyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    private static final Logger log = LoggerFactory.getLogger(ControllerAdvice.class);
    private static final String INVALID_DTO_FIELD_ERROR_MESSAGE_FORMAT = "%s 필드는 %s (전달된 값: %s)";

    @ExceptionHandler({InvalidHobbyException.class})
    public ResponseEntity<ErrorResponse> handleInvalidException(final RuntimeException e){
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler({DuplicatedHobbyException.class})
    public ResponseEntity<ErrorResponse> handleDuplicatedException(final RuntimeException e){
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

    @ExceptionHandler({UnAuthorizedHobbyException.class})
    public  ResponseEntity<ErrorResponse> handleUnAuthorizedException(final RuntimeException e){
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
    }
}
