package src.com.session.summer.calendar;

import src.com.session.summer.view.Printer;
import src.com.session.summer.view.Reader;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class WeekNumber extends Calendar {

    public WeekNumber(Reader reader, Printer printer) {
        super(reader, printer);
    }

    private static final LocalDate start = LocalDate.of(2020, 1, 1);
    private static final LocalDate end = LocalDate.of(2023, 1, 1);

    @Override
    public void execute() {
        LocalDate date = getDateInRange(start, end);
        printLine("Week number: " + getWeekNumber(date));
    }



    private int getWeekNumber(LocalDate date) {
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        return date.get(weekFields.weekOfWeekBasedYear());
    }

}
