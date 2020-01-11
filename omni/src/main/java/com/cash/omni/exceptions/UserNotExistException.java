package com.cash.omni.exceptions;

public class UserNotExistException extends Throwable {
    public UserNotExistException(String message){
        super(message);
    }
}
