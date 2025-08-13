package com.sirmascademy.SirmaRetakeExam.util;

import com.sirmascademy.SirmaRetakeExam.exception.DateFormatDetectionException;
import com.sirmascademy.SirmaRetakeExam.exception.DateParsingException;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


@Component
public class DateTimeFormatterUtil {

    private static final List<DateTimeFormatter> US_FORMATS = Arrays.asList(
            DateTimeFormatter.ofPattern("M-dd-yyyy"),
            DateTimeFormatter.ofPattern("M-d-yyyy"),
            DateTimeFormatter.ofPattern("MM-dd-yyyy"),
            DateTimeFormatter.ofPattern("MM-d-yyyy"),

            DateTimeFormatter.ofPattern("yyyy-dd-MM"),
            DateTimeFormatter.ofPattern("yyyy-d-MM"),
            DateTimeFormatter.ofPattern("yyyy-dd-M"),
            DateTimeFormatter.ofPattern("yyyy-d-M")

    );

    private static final List<DateTimeFormatter> EU_FORMATS = Arrays.asList(
            DateTimeFormatter.ofPattern("dd-MM-yyyy"),
            DateTimeFormatter.ofPattern("d-MM-yyyy"),
            DateTimeFormatter.ofPattern("dd-M-yyyy"),
            DateTimeFormatter.ofPattern("d-M-yyyy"),

            DateTimeFormatter.ofPattern("yyyy-MM-dd"),
            DateTimeFormatter.ofPattern("yyyy-MM-d"),
            DateTimeFormatter.ofPattern("yyyy-M-dd"),
            DateTimeFormatter.ofPattern("yyyy-M-d")

    );

    public static LocalDate parseDateFromFormat(String date, List<DateTimeFormatter> dateFormats) {
        String normalizedDate = normalizeDate(date);

        for (DateTimeFormatter dateTimeFormatter : dateFormats) {
            try {
                return LocalDate.parse(normalizedDate, dateTimeFormatter);
            } catch (DateTimeParseException e) {

            }
        }

        throw new DateParsingException("Cannot parse date: " + date);
    }

    public static List<DateTimeFormatter> detectDateFormat(String resourcePath, int dateColumnIndex) {
        try (InputStream inputStream = DateTimeFormatterUtil.class.getResourceAsStream(resourcePath);
             BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(inputStream)))) {

            String line;
            boolean isFirstRow = true;

            while ((line = reader.readLine()) != null) {
                if (isFirstRow) {
                    isFirstRow = false;
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length <= dateColumnIndex){
                    continue;
                }

                String dateStr = parts[dateColumnIndex].trim();
                if (dateStr.isEmpty()) {
                    continue;
                }

                boolean usValid = tryParse(dateStr, DateTimeFormatterUtil.US_FORMATS);
                boolean euValid = tryParse(dateStr, DateTimeFormatterUtil.EU_FORMATS);

                if (usValid && !euValid) {
                    System.out.println("US formats chosen for: " + resourcePath);
                    return DateTimeFormatterUtil.US_FORMATS;
                }

                if (euValid && !usValid) {
                    System.out.println("EU formats chosen for: " + resourcePath);
                    return DateTimeFormatterUtil.EU_FORMATS;
                }

            }

            throw new DateFormatDetectionException("Could not detect date format for: " + resourcePath);

        } catch (IOException e) {
            throw new DateFormatDetectionException("Error detecting date format for: " + resourcePath, e);
        }
    }

    private static boolean tryParse(String date, List<DateTimeFormatter> formats) {
        String normalizedDate = normalizeDate(date);

        for (DateTimeFormatter formatter : formats) {
            try {
                LocalDate.parse(normalizedDate, formatter);
                return true;
            } catch (DateTimeParseException ignored) { }
        }

        return false;
    }

    private static String normalizeDate(String date) {
        return date.replaceAll("[.\\-/ ]", "-");
    }

}
