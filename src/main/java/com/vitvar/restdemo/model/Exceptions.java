package com.vitvar.restdemo.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class Exceptions {

    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "resource not found")
    public static class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String msg) {
            super(msg);
        }
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public static class DataException extends RuntimeException {
        public DataException(String msg) {
            super(msg);
        }
    }

}
