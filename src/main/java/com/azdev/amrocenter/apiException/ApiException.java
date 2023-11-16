package com.azdev.amrocenter.apiException;

public class ApiException extends RuntimeException{
    public ApiException(String message) {
        super(message);
    }
}
