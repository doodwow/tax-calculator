package com.taxcalculator.exception;


public class InvalidItemException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_MESSAGE = "Invalid line item";

    public InvalidItemException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidItemException(String line) {
        super(String.format("Line item: (%s) is invalid", line));
    }

}
