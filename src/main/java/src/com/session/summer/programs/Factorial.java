package src.com.session.summer.programs;

import src.com.session.summer.controlers.SimplePrograms;
import src.com.session.summer.view.Printer;
import src.com.session.summer.view.Reader;

public class Factorial extends SimplePrograms {
    public Factorial(Reader reader, Printer printer) {
        super(reader, printer);
    }

    @Override
    public void execute() {
        int number = getNumber(0, 70);
        printLine(String.valueOf(getFactorial(number)));

    }

    private static long getFactorial(int number) {
        if (number == 0 || number == 1) {
            return 1;
        }
        return number * getFactorial(number - 1);
    }
}
