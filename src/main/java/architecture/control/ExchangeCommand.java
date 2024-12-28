package architecture.control;

import architecture.model.Currency;
import architecture.model.ExchangeRate;
import architecture.model.Money;
import architecture.persistence.ExchangeRateLoader;
import architecture.view.CurrencyDialog;
import architecture.view.DatePicker;
import architecture.view.MoneyDialog;
import architecture.view.MoneyDisplay;

import java.util.Date;

public class ExchangeCommand implements Command{
    private final MoneyDialog moneyDialog;
    private final MoneyDisplay moneyDisplay;
    private final DatePicker datePicker;
    private final ExchangeRateLoader loader;
    private final CurrencyDialog currencyDialog;

    private ExchangeCommand(MoneyDialog moneyDialog, MoneyDisplay moneyDisplay, DatePicker datePicker,
                           ExchangeRateLoader loader, CurrencyDialog currencyDialog){
        this.currencyDialog = currencyDialog;
        this.datePicker = datePicker;
        this.moneyDisplay = moneyDisplay;
        this.moneyDialog = moneyDialog;
        this.loader = loader;
    }

    public static ExchangeCommand with(MoneyDialog moneyDialog, MoneyDisplay moneyDisplay, DatePicker datePicker,
                                       ExchangeRateLoader loader, CurrencyDialog currencyDialog){
        return new ExchangeCommand(moneyDialog, moneyDisplay, datePicker, loader, currencyDialog);
    }

    @Override
    public void execute() {
        Money fromMoney = moneyDialog.get();
        Currency toCurrency = currencyDialog.get();
        Date date = datePicker.get();



        ExchangeRate exchangeRate = loader.load(fromMoney.currency(), toCurrency, date);
        Money result = new Money(toCurrency, fromMoney.amount() * exchangeRate.rate());

        moneyDisplay.show(result);

    }
}
