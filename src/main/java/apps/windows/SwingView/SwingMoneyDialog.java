package apps.windows.SwingView;

import architecture.model.Currency;
import architecture.model.Money;
import architecture.view.MoneyDialog;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.List;

public class SwingMoneyDialog extends JPanel implements MoneyDialog {
    private final TextField amount;
    private final List<Currency> currencies;
    private final SwingCurrencyDialog currencyDialog;


    public SwingMoneyDialog(List<Currency> currencies){
        this.currencies = currencies;
        this.setLayout(new FlowLayout());
        this.add(amount = createAmountInput());
        this.add(currencyDialog = new SwingCurrencyDialog(currencies));
    }



    private TextField createAmountInput() {
        TextField textField = new TextField();
        textField.setColumns(4);
        return textField;
    }

    @Override
    public Money get() {
        return new Money(currencyDialog.get(), toDouble(amount.getText()));
    }

    private double toDouble(String text) {
        return Double.parseDouble(text);
    }
}
