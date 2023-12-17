package ru.otus.spring.integration.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** Констарны для работы с датами
 * */

@Getter
@AllArgsConstructor
public enum DateFormatConstant {

   CBR_REQUEST("dd/MM/yyyy"),
   CBR_RESPONSE("dd.MM.yyyy"),
   SPIMEX_DB("yyyy-MM-dd");

   private final String value;

}
