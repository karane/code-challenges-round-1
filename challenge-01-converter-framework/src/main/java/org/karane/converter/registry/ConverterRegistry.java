package org.karane.converter.registry;

import org.karane.converter.ConversionException;
import org.karane.converter.Converter;

import java.util.HashMap;
import java.util.Map;

public class ConverterRegistry {

    private final Map<ConverterKey, Converter<?, ?>> converters = new HashMap<>();

    public <S, T> void register(Class<S> sourceType, Class<T> targetType, Converter<S, T> converter) {
        converters.put(new ConverterKey(sourceType, targetType), converter);
    }

    @SuppressWarnings("unchecked")
    public <S, T> Converter<S, T> lookup(Class<S> sourceType, Class<T> targetType) {
        Converter<?, ?> converter = converters.get(new ConverterKey(sourceType, targetType));
        if (converter == null) {
            throw new ConversionException(
                "No converter registered for " + sourceType.getSimpleName() + " -> " + targetType.getSimpleName()
            );
        }
        return (Converter<S, T>) converter;
    }

    public boolean canConvert(Class<?> sourceType, Class<?> targetType) {
        return converters.containsKey(new ConverterKey(sourceType, targetType));
    }
}
