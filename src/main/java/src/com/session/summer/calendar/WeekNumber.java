package src.com.session.summer.calendar;

import src.com.session.summer.view.Printer;
import src.com.session.summer.view.Reader;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class WeekNumber extends DayOfWeek {
    public WeekNumber(Reader reader, Printer printer) {
        super(reader, printer);
    }

    private static LocalDate start = LocalDate.of(2020, 1, 1);
    private static LocalDate end = LocalDate.of(2023, 1, 1);

    @Override
    public void execute() {
        LocalDate date = getDateInRange();
        printLine("Week number: " + getWeekNumber(date));
    }

    private LocalDate getDateInRange() {
        LocalDate date = getDate();
        if (date.isBefore(start) || date.isAfter(end)) {
            printLine(String.format("Please input yours date in interval between %s and %s",
                    start.format(formatter), end.format(formatter)));
            return getDateInRange();
        }

        return date;
    }

    private int getWeekNumber(LocalDate date) {
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        return date.get(weekFields.weekOfWeekBasedYear());
    }

}
