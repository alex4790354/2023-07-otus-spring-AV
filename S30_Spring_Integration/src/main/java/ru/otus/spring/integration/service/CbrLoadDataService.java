package ru.otus.spring.integration.service;



import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;
import ru.otus.spring.integration.domain.CurrencyDto;
import ru.otus.spring.integration.domain.CurrencyRateDto;
import ru.otus.spring.integration.exception.PostgresException;
import ru.otus.spring.integration.repository.ReceiverCbrRepository;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CbrLoadDataService {

    private final ReceiverCbrRepository receiverCbrRepository;

    public void loadCurrency(List<CurrencyDto> currenciesList) {

        try {
            receiverCbrRepository.saveCurrenciesList(currenciesList);
        } catch (BadSqlGrammarException e) {
            log.error("\nError --> {}\n Message --> {}", e.getSql(), e.getMessage());
            throw new PostgresException(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                    e.getSql(),
                    e.getSQLException());
        }
    }

    public void loadCurrencyRates(List<CurrencyRateDto> rateList) {

        try {
            receiverCbrRepository.saveRatesListWithHistory(rateList);
        } catch (BadSqlGrammarException e) {
            log.error("\nError --> {}\n Message --> {}", e.getSql(), e.getMessage());
            throw new PostgresException(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                    e.getSql(),
                    e.getSQLException());
        }
    }

    public void loadCurrencyRate(CurrencyRateDto currencyRateDto) {

        try {
            receiverCbrRepository.saveRateWithHistory(currencyRateDto);
        } catch (BadSqlGrammarException e) {
            log.error("\nError --> {}\n Message --> {}", e.getSql(), e.getMessage());
            throw new PostgresException(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                    e.getSql(),
                    e.getSQLException());
        }
    }


}
