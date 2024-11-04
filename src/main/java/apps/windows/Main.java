package apps.windows;

import apps.windows.Fixer.FixerCurrencyLoader;

public class Main {
    public static void main(String[] args) {
        FixerCurrencyLoader currencyLoader = new FixerCurrencyLoader();
        currencyLoader.loadCurrencies();
    }
}
