package ru.otus.spring.integration.domain;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
public class RateDtoDb {

    protected String id;
    protected LocalDate effectiveDate;
    protected long nominal;
    protected String firstCrncy;
    protected String secondCrncy;
    protected double value;
    protected OffsetDateTime creationTime;

}
