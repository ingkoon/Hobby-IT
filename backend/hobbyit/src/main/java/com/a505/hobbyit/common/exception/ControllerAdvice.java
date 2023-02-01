package com.a505.hobbyit.common.exception;

import com.a505.hobbyit.common.exception.dto.ErrorResponse;
import com.a505.hobbyit.hobby.exception.DuplicatedHobbyException;
import com.a505.hobbyit.hobby.exception.InvalidHobbyException;
import com.a505.hobbyit.hobby.exception.NoSuchHobbyException;
import com.a505.hobbyit.hobbymember.exception.NoSuchHobbyMemberException;
import com.a505.hobbyit.hobbymember.exception.UnAuthorizedHobbyMemberException;
import com.a505.hobbyit.pending.DuplicatedPendingException;
import com.a505.hobbyit.pending.exception.NoSuchPendingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    private static final Logger log = LoggerFactory.getLogger(ControllerAdvice.class);

    @ExceptionHandler({InvalidHobbyException.class})
    public ResponseEntity<ErrorResponse> handleInvalidException(final RuntimeException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
        log.info(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler({
            NoSuchHobbyException.class,
            NoSuchHobbyMemberException.class,
            NoSuchPendingException.class})
    public ResponseEntity<ErrorResponse> handleNoSuchElementException(final RuntimeException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(errorResponse);
    }

    @ExceptionHandler({
            DuplicatedHobbyException.class,
            DuplicatedPendingException.class})
    public ResponseEntity<ErrorResponse> handleDuplicatedException(final RuntimeException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

    @ExceptionHandler({UnAuthorizedHobbyMemberException.class})
    public ResponseEntity<ErrorResponse> handleUnAuthorizedException(final RuntimeException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
    }
}
