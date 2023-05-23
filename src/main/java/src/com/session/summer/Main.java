package src.com.session.summer;

import src.com.session.summer.util.Config;
import src.com.session.summer.view.ConsolePrinter;
import src.com.session.summer.view.KeyboardReader;
import src.com.session.summer.view.MainExecutor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        KeyboardReader reader = new KeyboardReader(new Scanner(System.in));
        ConsolePrinter printer = new ConsolePrinter(System.out);
        Connection connection = Config.getInstance().getConnection();

        MainExecutor executor = new MainExecutor(reader,printer,connection);
        executor.execute();
    }
}


