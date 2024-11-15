package apps.windows;

import apps.windows.Fixer.FixerCurrencyLoader;
import apps.windows.Fixer.FixerExchangeRateLoader;
import architecture.control.ExchangeCommand;
import architecture.model.Currency;

import java.util.List;


public class Main {
    public static void main(String[] args) {

        FixerCurrencyLoader fixerCurrencyLoader = new FixerCurrencyLoader();
        FixerExchangeRateLoader fixerExchangeRateLoader = new FixerExchangeRateLoader();
        List<Currency> currencies = fixerCurrencyLoader.loadCurrencies();
        MainFrame mainFrame = new MainFrame(currencies);

        ExchangeCommand exchangeCommand = new ExchangeCommand(
                mainFrame.moneyDialog(),
                mainFrame.moneyDisplay(),
                mainFrame.datePicker(),
                fixerExchangeRateLoader,
                mainFrame.currencyDialog()
        );
        mainFrame.add("exchange", exchangeCommand);
        mainFrame.setVisible(true);

        //System.out.println(exchangeRate);

    }
}
