package ru.otus.spring.integration.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
public class CurrencyRateDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("num_code")
    private int numCode;

    @JsonProperty("char_code")
    private String charCode;

    @JsonProperty("nominal")
    private long nominal;

    @JsonProperty("name")
    private String name;

    @JsonProperty("value")
    private double value;

    @JsonProperty("vunit_rate")
    private double vunitRate;

    @JsonProperty("date")
    private String dateAsString;  //  in "yyyy-MM-dd" format.

    public LocalDate getEffectiveDate() {
        return LocalDate.parse(dateAsString,
                DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

}
