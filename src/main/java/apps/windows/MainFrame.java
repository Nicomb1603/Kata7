package apps.windows;

import apps.windows.SwingView.SwingCurrencyDialog;
import apps.windows.SwingView.SwingDatePicker;
import apps.windows.SwingView.SwingMoneyDialog;
import apps.windows.SwingView.SwingMoneyDisplay;
import architecture.control.Command;
import architecture.model.Currency;
import architecture.view.CurrencyDialog;
import architecture.view.DatePicker;
import architecture.view.MoneyDialog;
import architecture.view.MoneyDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainFrame extends JFrame {
    private final List<Currency> currencies;
    private final SwingCurrencyDialog currencyDialog;
    private final SwingMoneyDialog moneyDialog;
    private final SwingDatePicker calendar;
    private final JButton executeButton;
    private final SwingMoneyDisplay moneyDisplay;
    private final Map<String, Command> commands;

    public MainFrame(List<Currency> currencies){
        this.currencies = currencies;
        this.setTitle("MoneyCalculator");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());
        this.add(moneyDialog = createMoneyDialog());
        this.add(currencyDialog = createCurrencyDialog());
        this.add(calendar = new SwingDatePicker());
        this.add(executeButton = createExecuteButton());
        this.add(moneyDisplay = createMoneyDisplay());
        this.commands = new HashMap<>();

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static MainFrame with(List<Currency> currencies){
        return new MainFrame(currencies);
    }

    private static SwingMoneyDisplay createMoneyDisplay() {
        return new SwingMoneyDisplay();
    }

    private JButton createExecuteButton() {
        JButton button = new JButton("Exchange");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {commands.get("exchange").execute();}
        });
        return button;
    }

    private SwingMoneyDialog createMoneyDialog() {return new SwingMoneyDialog(currencies);}

    private SwingCurrencyDialog createCurrencyDialog() {return new SwingCurrencyDialog(currencies);}

    public DatePicker datePicker(){
        return calendar;
    }

    public MoneyDisplay moneyDisplay(){
        return moneyDisplay;
    }

    public CurrencyDialog currencyDialog(){
        return currencyDialog;
    }

    public MoneyDialog moneyDialog(){
        return moneyDialog;
    }

    public MainFrame add(String operation, Command command){
        this.commands.put(operation, command);
        return this;
    }

}
