package apps.windows;

import apps.windows.SwingView.SwingCurrencyDialog;
import apps.windows.SwingView.SwingMoneyDialog;
import architecture.model.Currency;
import architecture.view.MoneyDialog;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainFrame extends JFrame {
    private final List<Currency> currencies;
    private final SwingCurrencyDialog currencyDialog;
    private final SwingMoneyDialog moneyDialog;

    public MainFrame(List<Currency> currencies){
        this.currencies = currencies;
        this.setTitle("MoneyCalculator");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());
        this.add(moneyDialog = createMoneyDialog());
        this.add(currencyDialog = createCurrencyDialog());
        this.setVisible(true);
    }


    private SwingMoneyDialog createMoneyDialog() {return new SwingMoneyDialog(currencies);}

    private SwingCurrencyDialog createCurrencyDialog() {return new SwingCurrencyDialog(currencies);}


}
