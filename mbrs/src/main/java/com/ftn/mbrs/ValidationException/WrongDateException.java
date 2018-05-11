package com.ftn.mbrs.ValidationException;

@SuppressWarnings("serial")
public class WrongDateException extends Exception {
    public WrongDateException(String message) {
        super(message);
    }
}