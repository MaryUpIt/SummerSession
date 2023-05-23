package src.com.session.summer.calendar;

import src.com.session.summer.controlers.SimplePrograms;
import src.com.session.summer.view.Printer;
import src.com.session.summer.view.Reader;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class DayOfWeek extends SimplePrograms {
    protected static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd:MM:yyyy");

    public DayOfWeek(Reader reader, Printer printer) {
        super(reader, printer);
    }

    @Override
    public void execute() {
        LocalDate date = getDate();
        printLine(date.getDayOfWeek().toString());
    }


    protected LocalDate getDate() {
        printLine("Input your day in format dd:MM:yyyy");
        try {
            return LocalDate.parse(getLine(), formatter);

        } catch (DateTimeParseException e) {
            printLine("This's not a date");
            return getDate();
        }
    }
}
