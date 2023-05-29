package src.com.session.summer.calendar;

import src.com.session.summer.controlers.SimplePrograms;
import src.com.session.summer.view.Printer;
import src.com.session.summer.view.Reader;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public abstract class Calendar extends SimplePrograms {
    protected static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd:MM:yyyy");

    protected Calendar(Reader reader, Printer printer) {
        super(reader, printer);
    }

    protected LocalDate getDate() {
        printLine("Input your day in format dd:MM:yyyy");
        try {
            return LocalDate.parse(getLine("Input your date: "), formatter);

        } catch (DateTimeParseException e) {
            printLine("This's not a date");
            return getDate();
        }
    }

    protected LocalDate getDateInRange(LocalDate start, LocalDate end) {
        LocalDate date = getDate();
        if (date.isBefore(start) || date.isAfter(end)) {
            printLine(String.format("Please input yours date in interval between %s and %s",
                    start.format(formatter), end.format(formatter)));
            return getDateInRange(start,end);
        }
        return date;
    }
}
