package org.karane.converter;

import org.karane.converter.builtin.*;
import org.karane.converter.registry.ConverterRegistry;
import org.karane.converter.service.ConversionService;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        ConverterRegistry registry = new ConverterRegistry();
        registry.register(String.class, Integer.class, new StringToIntegerConverter());
        registry.register(String.class, Double.class, new StringToDoubleConverter());
        registry.register(String.class, Boolean.class, new StringToBooleanConverter());
        registry.register(String.class, LocalDate.class, new StringToLocalDateConverter());
        registry.register(Integer.class, String.class, new IntegerToStringConverter());

        ConversionService service = new ConversionService(registry);

        Integer intValue = service.convert("42", Integer.class);
        System.out.println("String -> Integer: " + intValue);

        Double doubleValue = service.convert("3.14", Double.class);
        System.out.println("String -> Double: " + doubleValue);

        Boolean boolValue = service.convert("yes", Boolean.class);
        System.out.println("String -> Boolean: " + boolValue);

        LocalDate dateValue = service.convert("2026-05-10", LocalDate.class);
        System.out.println("String -> LocalDate: " + dateValue);

        String strValue = service.convert(100, String.class);
        System.out.println("Integer -> String: " + strValue);

        // Custom converter registered inline
        registry.register(String.class, Long.class, source -> Long.parseLong(source.trim()));
        Long longValue = service.convert("9876543210", Long.class);
        System.out.println("String -> Long (inline): " + longValue);
    }
}
