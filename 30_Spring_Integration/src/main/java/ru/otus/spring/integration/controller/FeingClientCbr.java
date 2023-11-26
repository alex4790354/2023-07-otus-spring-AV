package ru.otus.spring.integration.controller;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import generated.daily.ValCurs;


/**
 * Fain client interface for downloading data from CBR.
 * <a href="https://www.cbr.ru/currency_base/daily/">Official exchange rates for a given date, set daily</a>
 * <a href="https://www.cbr.ru/development/SXML/">Retrieving data using XML</a>
 * *
 * <a href="https://www.cbr.ru/scripts/XML_val.asp?d=0">Daily currencies list (xml)</a>
 * <a href="https://www.cbr.ru/scripts/XML_daily.asp?date_req=20/11/2023">Daily exchange rates example</a>
 * *
 * @author Alexander V
 */

@FeignClient(value = "FeedCbr", url = "${feign.url-client}")
public interface FeingClientCbr {


    /**
     * Выгрузка:
     *  - <a href="https://www.cbr.ru/scripts/XML_daily.asp?date_req=02/03/2002">Daily exchange rates example</a>
     *  - dateAsString in dd/MM/yyyy формате
     * <a href="https://www.cbr.ru/development/SXML/">Help</a>
     * *
     */
    @GetMapping(value = "/scripts/XML_daily.asp", params = {"date_req"})
    @Headers("Content-Type: application/xml")
    ResponseEntity<ValCurs> feinGetRatesOnDate(@RequestParam(value = "date_req") String dateAsString);


}

