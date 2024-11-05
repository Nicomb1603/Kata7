package architecture.persistence;

import architecture.model.Currency;
import architecture.model.ExchangeRate;

import java.time.LocalDate;

public interface ExchangeRateLoader {
    ExchangeRate load(Currency from, Currency to, LocalDate date);
}
