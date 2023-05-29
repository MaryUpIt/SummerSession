package src.com.session.summer;

import src.com.session.summer.calendar.WorkCalendarGenerator;
import src.com.session.summer.view.ConsolePrinter;
import src.com.session.summer.view.KeyboardReader;
import src.com.session.summer.controlers.FirstPartExecutor;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        KeyboardReader reader = new KeyboardReader(new Scanner(System.in));
        ConsolePrinter printer = new ConsolePrinter(System.out);
     //   Connection connection = Config.getInstance().getConnection();
        WorkCalendarGenerator generator = new WorkCalendarGenerator(reader, printer);
        generator.execute();

//
//        FirstPartExecutor executor = new FirstPartExecutor(reader,printer); //,connection);
//        executor.execute();
    }
}


