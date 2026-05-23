package org.karane.converter.builtin;

import org.karane.converter.ConversionException;
import org.karane.converter.Converter;

public class StringToIntegerConverter implements Converter<String, Integer> {

    @Override
    public Integer convert(String source) {
        try {
            return Integer.parseInt(source.trim());
        } catch (NumberFormatException e) {
            throw new ConversionException("Cannot convert \"" + source + "\" to Integer", e);
        }
    }
}
