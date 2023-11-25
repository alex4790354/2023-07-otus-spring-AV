package ru.otus.spring.integration.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RateDto {

    @JsonProperty("id")
    protected String id;
    @JsonProperty("num_code")
    protected int numCode;
    @JsonProperty("char_code")
    protected String charCode;
    @JsonProperty("nominal")
    protected long nominal;
    @JsonProperty("name")
    protected String name;
    @JsonProperty("value")
    protected double value;
    @JsonProperty("vunit_rate")
    protected double vunitRate;
    @JsonProperty("date")
    protected String dateAsString;  //  in "yyyy-MM-dd" format.

}
