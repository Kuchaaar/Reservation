package com.Airlines.Reservation.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SeatClass{
    FIRST_CLASS("1st class"),
    SECOND_CLASS("2nd class");

    private final String displayName;

    SeatClass(String displayName){
        this.displayName = displayName;
    }

    @JsonValue
    public String getDisplayName(){
        return displayName;
    }
}
