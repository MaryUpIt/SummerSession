package src.com.session.summer.programs;

import src.com.session.summer.controlers.Executor;
import src.com.session.summer.view.Printer;

public class Cubes implements Executor {
    private final Printer printer;

    public Cubes(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void execute() {
        int i = 1;
        while (i <= 10) {
            printer.printNewLine(String.valueOf(getCubeOfNumber(i)));
            i++;
        }

    }


    private int getCubeOfNumber(int i) {
        return i * i * i;
    }


}
