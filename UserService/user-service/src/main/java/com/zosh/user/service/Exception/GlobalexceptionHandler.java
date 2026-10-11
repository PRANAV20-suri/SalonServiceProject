package com.zosh.user.service.Exception;

import com.zosh.user.service.Payload.Exceptionresponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;


@RestControllerAdvice
public class GlobalexceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Exceptionresponse> handleValidationException(
            ConstraintViolationException ex,
            WebRequest webRequest) {

        Exceptionresponse er = new Exceptionresponse();

        er.setMessage(
                ex.getConstraintViolations()
                        .stream()
                        .map(violation -> violation.getMessage())
                        .findFirst()
                        .orElse("Validation failed")
        );

        er.setError(webRequest.getDescription(false));
        er.setLocaldateTime(LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Exceptionresponse> handleException(
            Exception ex, WebRequest webRequest) {

        Exceptionresponse er = new Exceptionresponse();
        er.setMessage(ex.getMessage());
        er.setError(webRequest.getDescription(false));
        er.setLocaldateTime(LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(er);
    }
}

