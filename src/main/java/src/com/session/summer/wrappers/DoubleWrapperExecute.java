package src.com.session.summer.wrappers;

import src.com.session.summer.controlers.MenuExecutor;
import src.com.session.summer.view.Printer;
import src.com.session.summer.view.Reader;

public class DoubleWrapperExecute extends MenuExecutor {
    public DoubleWrapperExecute(Reader reader, Printer printer) {
        super(reader, printer);
    }

    String MENU = """
            This is class DoubleWrapper you can:
            1. Addition of numbers
            2. Division of numbers
            3. Raising number to a power
            Your input:
            """;

    @Override
    protected void executeMenuItem() {
        int input = getInputNumber(MENU);
        switch (input) {
            case 1, 2, 3 -> calculate(input);
            default -> printer.printNewLine("it's not command");
        }
    }

    private void calculate(int input) {
        DoubleWrapper first = new DoubleWrapper(getDoubleNumber());
        DoubleWrapper second = new DoubleWrapper(getDoubleNumber());
        DoubleWrapper result = switch (input) {

            case 1 -> DoubleWrapper.addition(first, second);
            case 2 -> DoubleWrapper.division(first,second);
            case 3 -> DoubleWrapper.power(first,second);
            default -> throw new IllegalStateException("Unexpected value: " + input);
        };
        printer.printNewLine(result.toString());
    }
}
