package src.com.session.summer.view;

import src.com.session.summer.calculatorMySql.CalculatorExecutor;
import src.com.session.summer.programs.DigitsInNumber;
import src.com.session.summer.programs.EnglishAlphabet;
import src.com.session.summer.programs.NumbersInString;
import src.com.session.summer.programs.StringCalculator;
import src.com.session.summer.view.Executor;
import src.com.session.summer.view.MenuExecutor;
import src.com.session.summer.view.Printer;
import src.com.session.summer.view.Reader;

import java.sql.Connection;
import java.sql.SQLException;

public class MainExecutor extends MenuExecutor {
    private final Connection connection;
    private final String MENU = """            
            Select an command from the menu:
            1. Calculator with MySQL
            2. Get all numbers from string
            3. Get all digits from a number
            4. String calculator
            5. The implementation of a binary search tree
            6. Print english alphabet
            7. Print word any times
            8. The cubes of the first ten positive numbers
            9. Determine day of the week for a date
            10. Find the week number for a date from 2020 to 2022
            11. Exit
            Your input:  
            """;

    public MainExecutor(Reader reader, Printer printer, Connection connection) {
        super(reader, printer);
        this.connection = connection;
    }

    @Override
    public void executeMenuItem() {
        int input = getInputNumber(MENU);
        if (input == 11) {
            printer.printNewLine("Goodbye!");
            return;
        }
        Executor executor =  switch (input) {
          //  case 1 -> new CalculatorExecutor(reader, printer, connection);
            case 2 -> new NumbersInString(reader,printer);
            case 3 -> new DigitsInNumber(reader,printer);
            case 4 -> new StringCalculator(reader,printer);
            //case 5
            case 6 -> new EnglishAlphabet(printer);
           // case 7
            default -> null;
        };






    }


}
