package org.jacp.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoEntityException.class)
    ProblemDetail handleNoEntityException(NoEntityException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
        problemDetail.setTitle("Object is not found");
        problemDetail.setType(URI.create("https://datatracker.ietf.org/doc/html/rfc7231#section-6.5.4"));
        problemDetail.setProperty("timestamp", Instant.now());

        return problemDetail;
    }
}