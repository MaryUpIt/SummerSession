package src.com.session.summer.calculatorMySql;

import src.com.session.summer.view.Printer;
import src.com.session.summer.view.Reader;
import java.sql.Connection;
import java.sql.SQLException;

import static src.com.session.summer.calculatorMySql.Operations.*;

public class CalculatorMenu {

    private final Reader READER;
    private final Printer PRINTER;
    private final Connection CONNECTION;

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


    public CalculatorMenu(Reader reader, Printer printer, Connection connection) {
        READER = reader;
        PRINTER = printer;
        this.CONNECTION = connection;
    }



    public void execute() throws SQLException {
        int choose = getInputNumber();
        if (choose == 11) {
            System.out.println("Goodbye!");
            return;
        }
        switch (choose) {
            case 1 -> SqlRequests.outputAllTables(CONNECTION);
            case 2 ->
                    SqlRequests.createTable(CONNECTION);

            case 3 -> Calculator.calculate(CONNECTION, READER, ADD);
            case 4 -> Calculator.calculate(CONNECTION, READER, SUBTRACT);
            case 5 -> Calculator.calculate(CONNECTION, READER, MULTIPLY);
            case 6 -> Calculator.calculate(CONNECTION, READER, DIV);
            case 7 -> Calculator.calculate(CONNECTION, READER, MODULO_DIV);
            case 8 -> Calculator.calculate(CONNECTION, READER, MODULUS);
            case 9 -> Calculator.calculate(CONNECTION, READER, POW);
            case 10 -> SqlRequests.saveToExcel(CONNECTION);
            default -> System.out.println("it's not command");
        }
        System.out.println();
        execute();
    }

    private int getInputNumber() {
        PRINTER.print(MENU);
        try {
            return READER.getIntNumber();
        }catch (NumberFormatException e) {
            PRINTER.printNewLine("Please, input only numbers");
            return getInputNumber();
        }
    }


}


