package src.com.session.summer.programs;

import src.com.session.summer.controlers.SimplePrograms;
import src.com.session.summer.view.Printer;
import src.com.session.summer.view.Reader;

public class AnyTimesPrinter extends SimplePrograms {

    public AnyTimesPrinter(Reader reader, Printer printer) {
        super(reader, printer);
    }

    @Override
    public void execute() {
        String line = getLine("Input your line: ");
        int count = getNumber();
        while (count > 0) {
            printLine(line);
            count--;
        }

    }


}
