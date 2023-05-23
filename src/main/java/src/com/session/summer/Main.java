package src.com.session.summer;

import src.com.session.summer.util.Config;
import src.com.session.summer.view.ConsolePrinter;
import src.com.session.summer.view.KeyboardReader;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        KeyboardReader reader = new KeyboardReader(new Scanner(System.in));
        ConsolePrinter printer = new ConsolePrinter(System.out);
        Connection connection = Config.getInstance().getConnection();


        // SqlRequests.dropTable(connection);

//        StringCalculator stringCalculator = new StringCalculator(reader);
//        stringCalculator.execute();

//        DigitsInNumber digitsInNumber = new DigitsInNumber(reader);
//        digitsInNumber.execute();
//        View view = new View(reader, connection);
//        view.;

//        NumbersInString numbersInString = new NumbersInString(reader);
//        numbersInString.execute();

    }

}
