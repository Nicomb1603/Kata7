package apps.windows.SwingView;

import architecture.model.Currency;
import architecture.model.Money;
import architecture.view.MoneyDialog;
import com.toedter.calendar.JCalendar;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SwingMoneyDialog extends JPanel implements MoneyDialog {
    private final TextField amount;
    private final List<Currency> currencies;
    private final SwingCurrencyDialog currencyDialog;
    private final JCalendar calendar;

    public SwingMoneyDialog(List<Currency> currencies){
        this.currencies = currencies;
        this.setLayout(new FlowLayout());
        this.add(amount = createAmountInput());
        this.add(currencyDialog = new SwingCurrencyDialog(currencies));
        this.add(calendar = createCalendar());
    }

    private JCalendar createCalendar() {
        JCalendar calendar = new JCalendar();
        return calendar;
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
