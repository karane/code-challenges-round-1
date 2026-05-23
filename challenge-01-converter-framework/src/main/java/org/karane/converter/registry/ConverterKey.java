package org.karane.converter.registry;

import java.util.Objects;

final class ConverterKey {

    private final Class<?> sourceType;
    private final Class<?> targetType;

    ConverterKey(Class<?> sourceType, Class<?> targetType) {
        this.sourceType = sourceType;
        this.targetType = targetType;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ConverterKey other)) return false;
        return sourceType.equals(other.sourceType) && targetType.equals(other.targetType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sourceType, targetType);
    }

    @Override
    public String toString() {
        return sourceType.getSimpleName() + " -> " + targetType.getSimpleName();
    }
}
