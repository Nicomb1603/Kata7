package apps.windows;

import apps.windows.Fixer.FixerCurrencyLoader;
import apps.windows.Fixer.FixerExchangeRateLoader;
import architecture.model.Currency;
import architecture.model.ExchangeRate;
import architecture.persistence.ExchangeRateLoader;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //FixerCurrencyLoader currencyLoader = new FixerCurrencyLoader();
        ExchangeRateLoader exchangeRateLoader = new FixerExchangeRateLoader();
        ExchangeRate exchangeRate = exchangeRateLoader.load(new Currency("Euro", "EUR"), new Currency("United States Dollar", "USD"), LocalDate.now());

        System.out.println(exchangeRate);

    }
}
