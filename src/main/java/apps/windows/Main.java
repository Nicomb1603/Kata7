package apps.windows;

import apps.windows.Fixer.FixerCurrencyLoader;
import apps.windows.Fixer.FixerExchangeRateLoader;
import architecture.control.ExchangeCommand;
import architecture.model.Currency;

import java.util.List;


public class Main {
    public static void main(String[] args) {

        FixerCurrencyLoader fixerCurrencyLoader = FixerCurrencyLoader.create();
        FixerExchangeRateLoader fixerExchangeRateLoader = FixerExchangeRateLoader.create();
        List<Currency> currencies = fixerCurrencyLoader.loadCurrencies();
        MainFrame mainFrame = MainFrame.with(currencies);
        ExchangeCommand exchangeCommand = ExchangeCommand.with(
                mainFrame.moneyDialog(),
                mainFrame.moneyDisplay(),
                mainFrame.datePicker(),
                fixerExchangeRateLoader,
                mainFrame.currencyDialog()
        );

        mainFrame.add("exchange", exchangeCommand)
                .setVisible(true);

    }
}
