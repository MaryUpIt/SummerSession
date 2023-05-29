package src.com.session.summer.controlers;

import src.com.session.summer.view.Printer;
import src.com.session.summer.view.Reader;

public abstract class SimplePrograms implements Executor {
    private final Reader reader;
    protected final Printer printer;

    protected SimplePrograms(Reader reader, Printer printer) {
        this.reader = reader;
        this.printer = printer;
    }

    protected int getNumber(String input) {
        printer.print(input);
        try {
            return reader.getIntNumber();
        } catch (NumberFormatException e) {
            printer.printNewLine("It's not a number, try again!");
            return getNumber(input);
        }
    }

    protected int getNumber() {
        return getNumber("Input a number: ");
    }

    protected double getDoubleNumber() {
        printer.print("Input a number: ");
        try {
            return reader.getDoubleNumber();
        } catch (NumberFormatException e) {
            printer.printNewLine("It's not a number, try again!");
            return getNumber("Input a number: ");
        }
    }

    protected int getNumber( int min, int max) {
        int number = getNumber();
        if (min > number || number > max) {
            printer.printNewLine(String.format("Please input number in range between %d and %d", min, max));
            return getNumber(min, max);
        }
        return number;
    }


    protected String getLine(String input) {
        printer.print(input);
        return reader.getText();
    }

    protected void printLine(String message) {
        printer.printNewLine(message);
    }


}
