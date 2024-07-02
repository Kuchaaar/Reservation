package com.Airlines.Reservation.enums.converters;

import com.Airlines.Reservation.enums.SeatClass;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class SeatClassConverter implements AttributeConverter<SeatClass, String>{

    @Override
    public String convertToDatabaseColumn(SeatClass seatClass) {
        if (seatClass == null) {
            return null;
        }
        return seatClass.getDisplayName();
    }

    @Override
    public SeatClass convertToEntityAttribute(String displayName) {
        if (displayName == null) {
            return null;
        }
        return Stream.of(SeatClass.values())
                .filter(c -> c.getDisplayName().equals(displayName))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
