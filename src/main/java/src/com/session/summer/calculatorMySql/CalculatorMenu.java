package src.com.session.summer.calculatorMySql;

import src.com.session.summer.view.Printer;
import src.com.session.summer.view.Reader;

import java.sql.Connection;
import java.sql.SQLException;

import static src.com.session.summer.calculatorMySql.Operations.*;

public class CalculatorMenu {

    private final Reader reader;
    private final Printer printer;
    private final SqlRequests requests;

    private final String MENU = """            
            Select an command from the menu:
            1. Output all tables
            2. Create table in database
            3. Addition of numbers
            4. Number subtraction
            5. Multiplication of numbers
            6. Division of numbers
            7. Modulo division of numbers (remainder)
            8. Raising a number to a modulus
            9. Raising a number to a power
            10. Save all data to Excel
            11. Exit
            Your input: 
            """;

    private final String NEXT = "Do you wish to continue? yes/no: ";

    public CalculatorMenu(Reader reader, Printer printer, Connection connection) {
        this.reader = reader;
        this.printer = printer;
        this.requests = new SqlRequests(connection);
    }

    public void execute() throws SQLException {
        int inputNumber = getInputNumber(MENU);
        if (inputNumber == 11) {
            System.out.println("Goodbye!");
            return;
        }
        switch (inputNumber) {
            case 1 -> requests.outputAllTables();
            case 2 -> requests.createTable();
            case 10 -> requests.saveToExcel();
            case 3, 4, 5, 6, 7, 8, 9 -> {
                Operations operation = getOperation(inputNumber);
                if (operation == null) {
                    printer.printNewLine("it's not command");
                } else {
                    Number first = getNumber();
                    Number second = operation == MODULUS ? 0 : getNumber();
                    try {
                        Number result = Calculator.calculate(operation, first, second);
                        requests.insertValues(operation, first, second, result);
                    } catch (ArithmeticException e) {
                        printer.printNewLine(e.getMessage());
                    }
                }
            }
            default -> printer.printNewLine("it's not command");
        }
        if (isNext("")) {
            execute();
        } else {
            printer.printNewLine("Goodbye!");
        }
    }

    private Operations getOperation(int inputNumber) {
        return switch (inputNumber) {
            case 3 -> ADD;
            case 4 -> SUBTRACT;
            case 5 -> MULTIPLY;
            case 6 -> DIV;
            case 7 -> MODULO_DIV;
            case 8 -> MODULUS;
            case 9 -> POW;
            default -> null;
        };
    }

    private Number getNumber() {
        printer.print("Input number: ");
        try {
            return reader.getNumber();
        } catch (NumberFormatException e) {
            printer.printNewLine("Please, input only numbers");
            return getNumber();
        }
    }

    private boolean isNext(String message) {
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

    private int getInputNumber(String message) {
        printer.print(message);
        try {
            return reader.getIntNumber();
        } catch (NumberFormatException e) {
            printer.printNewLine("Please, input only numbers");
            return getInputNumber(message);
        }
    }

    private String getMessage(String message) {
        printer.print(message);
        return reader.getText();
    }
}


