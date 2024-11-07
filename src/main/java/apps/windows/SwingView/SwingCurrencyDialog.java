package apps.windows.SwingView;

import architecture.model.Currency;
import architecture.view.CurrencyDialog;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.ComboPopup;
import java.awt.*;
import java.util.List;

public class SwingCurrencyDialog extends JPanel implements CurrencyDialog {
    private final List<Currency> currencies;
    private final JComboBox selector;

    public SwingCurrencyDialog(List<Currency> currencies) {
        this.currencies = currencies;
        this.add(selector = createSelector());
    }

    private JComboBox createSelector() {
        JComboBox<Currency> comboBox = new JComboBox<>();
        comboBox.setUI(new setCustomComboBoxUI());
        for(Currency currency : currencies)
            comboBox.addItem(currency);
        return comboBox;
    }


    @Override
    public Currency get(){
        return currencies.get(selector.getSelectedIndex());
    }

    class setCustomComboBoxUI extends BasicComboBoxUI {
        @Override
        protected JButton createArrowButton() {
            JButton arrowButton = new JButton("▼");
            arrowButton.setBorder(new EmptyBorder(2, 2, 2, 2));
            arrowButton.setBackground(new Color(220, 220, 220));
            arrowButton.setForeground(Color.DARK_GRAY);
            arrowButton.setFocusPainted(false);
            return arrowButton;
        }

        @Override
        public void installUI(JComponent c) {
            super.installUI(c);
            comboBox.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150), 1, true));
            comboBox.setOpaque(false);
        }
    }
}
