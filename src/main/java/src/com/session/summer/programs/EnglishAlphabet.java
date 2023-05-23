package src.com.session.summer.programs;

import src.com.session.summer.view.Executor;
import src.com.session.summer.view.Printer;

public class EnglishAlphabet implements Executor {
    private final Printer printer;

    public EnglishAlphabet(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void execute() {
        char letter = 'a';
        while (letter <= 'z') {
            printer.print(letter == 'z' ? String.valueOf(letter) : letter + ", ");
            letter++;
        }
    }
}
