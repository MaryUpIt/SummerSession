package src.com.session.summer.view;

import java.io.PrintStream;

public class ConsolePrinter implements Printer {
    private  final PrintStream stream;;

    public ConsolePrinter(PrintStream stream) {
        this.stream = stream;
    }

    @Override
    public void print(String message) {
        stream.print(message);
    }

    @Override
    public void printNewLine(String message) {
        stream.println(message);
    }
}
