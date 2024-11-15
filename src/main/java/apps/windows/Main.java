package apps.windows;

import apps.windows.Fixer.FixerCurrencyLoader;
import apps.windows.Fixer.FixerExchangeRateLoader;
import architecture.model.Currency;
import architecture.model.ExchangeRate;
import architecture.persistence.ExchangeRateLoader;

import java.time.LocalDate;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.ComboPopup;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        //FixerCurrencyLoader currencyLoader = new FixerCurrencyLoader();
        //ExchangeRateLoader exchangeRateLoader = new FixerExchangeRateLoader();
        //ExchangeRate exchangeRate = exchangeRateLoader.load(new Currency("Euro", "EUR"), new Currency("United States Dollar", "USD"), LocalDate.now());

        List<Currency> currencies = List.of(new Currency("United States Dollar", "USD", "$"),
                new Currency("Euro", "EUR", "€"),
                new Currency("Yen", "JPY"));


        MainFrame mainFrame = new MainFrame(currencies);

        //System.out.println(exchangeRate);

    }
}
