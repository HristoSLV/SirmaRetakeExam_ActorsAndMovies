package com.sirmascademy.SirmaRetakeExam.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

@Component
public class DateTimeFormatterUtil {

    private static final List<DateTimeFormatter> DATE_FORMATS = Arrays.asList(
            DateTimeFormatter.ofPattern("M/dd/yyyy"),
            DateTimeFormatter.ofPattern("M/d/yyyy"),
            DateTimeFormatter.ofPattern("MM/dd/yyyy"),
            DateTimeFormatter.ofPattern("MM/d/yyyy"),

            DateTimeFormatter.ofPattern("yyyy-MM-dd"),
            DateTimeFormatter.ofPattern("yyyy-MM-d"),
            DateTimeFormatter.ofPattern("yyyy-M-dd"),
            DateTimeFormatter.ofPattern("yyyy-M-d")

    );

    public static LocalDate parseDateFromAllFormats(String date) {
        if (date == null || date.isBlank()) {
            throw new IllegalArgumentException("Date string cannot be null or blank");
        }

        for (DateTimeFormatter dateTimeFormatter : DATE_FORMATS) {
            try {
                return LocalDate.parse(date, dateTimeFormatter);
            } catch (DateTimeParseException e) {

            }
        }
        throw new IllegalArgumentException("Cannot parse date: " + date);
    }
}
