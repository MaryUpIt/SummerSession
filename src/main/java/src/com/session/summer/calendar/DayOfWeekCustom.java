package src.com.session.summer.calendar;

import src.com.session.summer.view.Printer;
import src.com.session.summer.view.Reader;

import java.time.DayOfWeek;
import java.time.LocalDate;


public class DayOfWeekCustom extends Calendar {

    public DayOfWeekCustom(Reader reader, Printer printer) {
        super(reader, printer);
    }

    @Override
    public void execute() {
        LocalDate date = getDate();
        printLine(getDayOfWeek(date).toString());
    }
    protected DayOfWeek getDayOfWeek(LocalDate date) {
        return date.getDayOfWeek();
    }

}
