package src.com.session.summer.controlers;

import src.com.session.summer.calculatorMySql.Calculator;
import src.com.session.summer.calculatorMySql.Operations;
import src.com.session.summer.calculatorMySql.SqlRequests;
import src.com.session.summer.controlers.MenuExecutor;
import src.com.session.summer.view.Printer;
import src.com.session.summer.view.Reader;

import java.sql.Connection;
import java.sql.SQLException;

import static src.com.session.summer.calculatorMySql.Operations.*;

public class CalculatorExecutor extends MenuExecutor {
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
            Your input: 
            """;

    public CalculatorExecutor(Reader reader, Printer printer, Connection connection) {
        super(reader, printer);
        this.requests = new SqlRequests(connection);
    }


    @Override
    protected void executeMenuItem() {
        try {
            menuAction();
        } catch (SQLException e) {
            printer.printNewLine(e.getMessage());
        }
    }

    public void menuAction() throws SQLException {
        int input = getInputNumber(MENU);
        switch (input) {
            case 1 -> requests.outputAllTables();
            case 2 -> requests.createTable();
            case 10 -> requests.saveToExcel();
            case 3, 4, 5, 6, 7, 8, 9 -> {
                Operations operation = getOperation(input);
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

}


