package architecture.persistence;

import architecture.model.Currency;
import architecture.model.ExchangeRate;

import java.time.LocalDate;
import java.util.Date;

public interface ExchangeRateLoader {
    ExchangeRate load(Currency from, Currency to, Date date);
}
