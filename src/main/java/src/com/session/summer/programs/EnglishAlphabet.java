package src.com.session.summer.programs;

import src.com.session.summer.controlers.Executor;
import src.com.session.summer.view.Printer;

public class EnglishAlphabet implements Executor {
    private final Printer printer;

    public EnglishAlphabet(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void execute() {
        printer.printNewLine(generateAlphabet());
    }

    private String generateAlphabet() {
        StringBuilder alphabet = new StringBuilder();
        char letter = 'a';
        while (letter <= 'z') {
            alphabet.append(letter == 'z' ? letter : letter + ", ");
            letter++;
        }
        return alphabet.toString();
    }
}
