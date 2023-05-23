package src.com.session.summer;

import src.com.session.summer.view.Printer;

import java.sql.Connection;
import java.util.Scanner;

public class MainMenu {
    private final Scanner SCANNER;
    private final Connection CONNECTION;
    private final Printer PRINTER;

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

    public MainMenu(Scanner scanner, Connection connection, Printer printer) {
        SCANNER = scanner;
        CONNECTION = connection;
        PRINTER = printer;
    }

    public void execute() {
        PRINTER.print(MENU);

    }




}
