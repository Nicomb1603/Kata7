package architecture.persistence;

import architecture.model.Currency;

import java.util.List;

public interface CurrencyLoader {
    List<Currency> loadCurrencies();
}
