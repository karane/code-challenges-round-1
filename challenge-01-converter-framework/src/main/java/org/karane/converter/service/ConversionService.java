package org.karane.converter.service;

import org.karane.converter.Converter;
import org.karane.converter.registry.ConverterRegistry;

public class ConversionService {

    private final ConverterRegistry registry;

    public ConversionService(ConverterRegistry registry) {
        this.registry = registry;
    }

    public <S, T> T convert(S source, Class<T> targetType) {
        if (source == null) {
            return null;
        }
        @SuppressWarnings("unchecked")
        Class<S> sourceType = (Class<S>) source.getClass();
        Converter<S, T> converter = registry.lookup(sourceType, targetType);
        return converter.convert(source);
    }

    public boolean canConvert(Class<?> sourceType, Class<?> targetType) {
        return registry.canConvert(sourceType, targetType);
    }
}
