package com.Airlines.Reservation.enums;

import com.Airlines.Reservation.exceptions.PhoneNumberParsingException;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;

import java.io.Serializable;

import static com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat.E164;

public class PhoneNumber implements Serializable{
    private static final PhoneNumberUtil PHONE_NUMBER_UTIL = PhoneNumberUtil.getInstance();

    final String value;

    public PhoneNumber(String value) {
        this.value = validateAndNormalizePhoneNumber(value);
    }

    private static String validateAndNormalizePhoneNumber(String value) {
        try {
            if (Long.parseLong(value) <= 0) {
                throw new PhoneNumberParsingException("The phone number cannot be negative: " + value);
            }
            final var phoneNumber = PHONE_NUMBER_UTIL.parse(value, "PL");
            final String formattedPhoneNumber = PHONE_NUMBER_UTIL.format(phoneNumber, E164);
            return formattedPhoneNumber.substring(1);
        } catch (NumberParseException | NumberFormatException e) {
            throw new PhoneNumberParsingException("The phone number isn't valid: " + value, e);
        }
    }
}
