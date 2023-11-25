package ru.otus.spring.integration.controller.feing;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.otus.spring.integration.domain.xml.ValCurs;


/**
 * Интерфейс фейн клиента удаленного вызова для выгрузки данных из СРБИ.
 * <a href="https://www.cbr.ru/currency_base/daily/">Official exchange rates for a given date, set daily</a>
 * <a href="https://www.cbr.ru/development/SXML/">Retrieving data using XML</a>
 * *
 * <a href="https://www.cbr.ru/scripts/XML_val.asp?d=0">Daily currencies list (xml)</a>
 * <a href="https://www.cbr.ru/scripts/XML_daily.asp?date_req=20/11/2023">Daily exchange rates example</a>
 * <a href="https://www.cbr.ru/scripts/XML_dynamic.asp?date_req1=01/01/2023&date_req2=14/11/2023&VAL_NM_RQ=R01235">Historical exchange rates example</a>
 *
 * @author Alexander Vasilev
 */

@FeignClient(value = "FeedCbr", url = "${feign.url-client}")
public interface FeingClientCbr {


    /**
     * Выгрузка:
     *  - с адреса: <a href="https://www.cbr.ru/scripts/XML_daily.asp?date_req=02/03/2002">Daily exchange rates example</a>
     *  - с повтором до успеха
     *  - dateAsString in dd/MM/yyyy формате
     * <a href="https://www.cbr.ru/development/SXML/">Справка</a>
     *
     * @return Возвращает generated. Valuta со списоком валют (Items)
     *
     */
    @GetMapping(value="/scripts/XML_daily.asp", params = {"date_req"})
    @Headers("Content-Type: application/xml")
    ResponseEntity<ValCurs> feinGetRatesOnDate(@RequestParam(value = "date_req") String dateAsString);


}

