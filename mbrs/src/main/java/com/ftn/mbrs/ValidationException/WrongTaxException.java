package com.ftn.mbrs.ValidationException;

@SuppressWarnings("serial")
public class WrongTaxException extends Exception {
	public WrongTaxException(String message) {
        super(message);
    }
}
