package org.karane.converter.builtin;

import org.karane.converter.ConversionException;
import org.karane.converter.Converter;

public class StringToBooleanConverter implements Converter<String, Boolean> {

    @Override
    public Boolean convert(String source) {
        return switch (source.trim().toLowerCase()) {
            case "true", "yes", "1" -> true;
            case "false", "no", "0" -> false;
            default -> throw new ConversionException("Cannot convert \"" + source + "\" to Boolean");
        };
    }
}
