package apps.windows.SwingView;

import architecture.view.DatePicker;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.util.Date;

public class SwingDatePicker extends JPanel implements DatePicker {
    private final JDateChooser calendar;

    public SwingDatePicker(){
        this.add(calendar = createCalendar());
    }

    @Override
    public Date get() {
        return calendar.getDate();
    }

    private JDateChooser createCalendar() {
        JDateChooser calendar = new JDateChooser();
        calendar.setDateFormatString("yyyy-MM-dd");
        calendar.setMaxSelectableDate(new Date());
        calendar.setDate(new Date());
        return calendar;
    }


}
