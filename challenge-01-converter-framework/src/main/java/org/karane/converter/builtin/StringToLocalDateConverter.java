package org.karane.converter.builtin;

import org.karane.converter.ConversionException;
import org.karane.converter.Converter;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class StringToLocalDateConverter implements Converter<String, LocalDate> {

    @Override
    public LocalDate convert(String source) {
        try {
            return LocalDate.parse(source.trim());
        } catch (DateTimeParseException e) {
            throw new ConversionException("Cannot convert \"" + source + "\" to LocalDate (expected ISO-8601 format yyyy-MM-dd)", e);
        }
    }
}
