package ru.otus.spring.integration.utils;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateHelper {


    /** Example:
     *    getDateAsString("05.20.2025",
     *                    "MM.dd.yyyy",
     *                    "yyyy-MM-dd")  =>  "2025-05-20"
     */
    public String getNewDateAsString(String providedDateAsString,
                                  String providedFormat,
                                  String requiredFormat) {

        LocalDate date = LocalDate.parse(providedDateAsString,
                DateTimeFormatter.ofPattern(providedFormat));

        return date.format(DateTimeFormatter.ofPattern(requiredFormat));
    }

    public String getTodateDateAsString(String requiredFormat) {
        return LocalDate.now().format(DateTimeFormatter.ofPattern(requiredFormat));
    }

}
