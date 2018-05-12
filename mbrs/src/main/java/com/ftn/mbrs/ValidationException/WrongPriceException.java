package com.ftn.mbrs.ValidationException;

@SuppressWarnings("serial")
public class WrongPriceException extends Exception {
	public WrongPriceException(String message) {
        super(message);
    }
}
