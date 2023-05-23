package src.com.session.summer.view;

import java.sql.SQLException;

public abstract class MenuExecutor implements Executor {

    protected final Reader reader;
    protected final Printer printer;
    private final String NEXT = "Do you wish to continue? yes/no: ";

    protected MenuExecutor(Reader reader, Printer printer) {
        this.reader = reader;
        this.printer = printer;
    }

    protected abstract void executeMenuItem();

    @Override
    public void execute() {
        executeMenuItem();
        if (isNext("")) {
            execute();
        } else {
            printer.printNewLine("Goodbye!");
        }
    }

    protected int getInputNumber(String message) {
        printer.print(message);
        try {
            return reader.getIntNumber();
        } catch (NumberFormatException e) {
            printer.printNewLine("Please, input only numbers");
            return getInputNumber(message);
        }
    }

    protected String getMessage(String message) {
        printer.print(message);
        return reader.getText();
    }

    protected boolean isNext(String message) {
        if (!message.isEmpty()) {
            printer.printNewLine(message);
        }
        String input = getMessage(NEXT);
        return switch (input.trim().toLowerCase()) {
            case "yes" -> true;
            case "no" -> false;
            default -> isNext("Try again");
        };
    }


}
