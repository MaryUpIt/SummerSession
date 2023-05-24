package src.com.session.summer.view;

import java.util.Scanner;

public class KeyboardReader implements Reader {

    private final Scanner scanner;

    public KeyboardReader(Scanner scanner) {
        this.scanner = scanner;
    }


    @Override
    public String getText() {
        return scanner.nextLine();
    }

    @Override
    public int getIntNumber() {
        return Integer.parseInt(scanner.nextLine().trim());
    }

    @Override
    public double getDoubleNumber() {
        return Double.parseDouble(scanner.nextLine().trim());
    }

    @Override
    public Number getNumber() {
        String line = scanner.nextLine();
        try {
            return Long.parseLong(line);
        } catch (NumberFormatException e) {
            return Double.parseDouble(line);
        }
    }
}
