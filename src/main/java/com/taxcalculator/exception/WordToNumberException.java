package com.taxcalculator.exception;


public class WordToNumberException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_MESSAGE = "Invalid number word";

    public WordToNumberException() {
        super(DEFAULT_MESSAGE);
    }

    public WordToNumberException(String line) {
        super(String.format("Number word: (%s) is invalid", line));
    }

}
