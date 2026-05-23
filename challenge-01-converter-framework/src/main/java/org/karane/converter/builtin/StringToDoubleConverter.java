package org.karane.converter.builtin;

import org.karane.converter.ConversionException;
import org.karane.converter.Converter;

public class StringToDoubleConverter implements Converter<String, Double> {

    @Override
    public Double convert(String source) {
        try {
            return Double.parseDouble(source.trim());
        } catch (NumberFormatException e) {
            throw new ConversionException("Cannot convert \"" + source + "\" to Double", e);
        }
    }
}
