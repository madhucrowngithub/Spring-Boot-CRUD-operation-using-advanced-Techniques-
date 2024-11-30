package com.myproject.jpademo.commons.error.handler;

import com.myproject.jpademo.commons.dto.Response;
import com.myproject.jpademo.commons.error.custom.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class ApiErrorHandler extends ResponseEntityExceptionHandler {
    @Autowired
    private Environment environment;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        log.error(ex.getMessage(), ex);
        //Get all errors
        String errors = Optional.of(ex.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(","))).orElse("validation errors in request");
        Response<Object> response = Response.validationException();
        response.addErrorMsgToResponse(errors);
        return new ResponseEntity<>(response, status);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<Response<Object>> handleConstraintViolationException(Exception ex, WebRequest request) {
        log.error(ex.getMessage(), ex);
        Response<Object> response = Response.validationException();
        response.addErrorMsgToResponse(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({EntityNotFoundException.class, /*UsernameNotFoundException.class*/})
    public final ResponseEntity<Response<Object>> handleNotFountExceptions(Exception ex, WebRequest request) {
        log.error(ex.getMessage(), ex);
        Response<Object> response = Response.notFound();
        response.addErrorMsgToResponse(ex.getMessage(), ex);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Response<Object>> handleStandardExceptions(Exception ex, WebRequest request) {
        log.error(ex.getMessage(), ex);
        Response<Object> response = Response.exception();
        if (returnActualError()) {
            response.addErrorMsgToResponse(ex.getMessage(), ex);
        } else {
            response.addErrorMsgToResponse("Application error");
        }
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private boolean returnActualError() {
        for (String en : environment.getActiveProfiles()) {
            if (en.equalsIgnoreCase("prod") || en.equalsIgnoreCase("production")) return false;
        }
        return true;
    }
}



