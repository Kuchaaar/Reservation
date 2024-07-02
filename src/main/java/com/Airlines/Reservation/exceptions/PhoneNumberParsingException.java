package com.Airlines.Reservation.exceptions;

public class PhoneNumberParsingException extends RuntimeException {
    public PhoneNumberParsingException(String message) {
        super(message);
    }

    public PhoneNumberParsingException(String message, Throwable cause) {
        super(message, cause);
    }
}
