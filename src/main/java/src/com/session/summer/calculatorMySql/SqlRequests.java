package src.com.session.summer.calculatorMySql;

import java.sql.*;

public class SqlRequests {
    private static final String TABLE_NAME = "calculation";
    private static final String[] COLUMN_NAMES
            = new String[]{"operation", "firstNumber", "secondNumber", "result"};
    private static int counter = 1;

    public static void outputAllTables(Connection connection) throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet = metaData.getTables(null, null, null, new String[]{"TABLE"});
        if (!resultSet.next()) {
            System.out.println("В MySQL пока нет таблиц");
        }
        System.out.println("Список таблиц в MySQL:");
        while (resultSet.next()) {
            String tableName = resultSet.getString("TABLE_NAME");
            System.out.println(tableName);
        }
    }

    public static void createTable(Connection connection) throws SQLException {
        StringBuilder createTableQuery = new StringBuilder(String.format("CREATE TABLE IF NOT EXISTS %s (" +
                "id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL, ", TABLE_NAME));
        for (int i = 0; i < COLUMN_NAMES.length; i++) {
            createTableQuery.append(String.format("%s VARCHAR(20) NOT NULL%s", COLUMN_NAMES[i],
                    (i != COLUMN_NAMES.length - 1 ? ", " : ")\n")));
        }
        Statement statement = connection.createStatement();
        statement.executeUpdate(createTableQuery.toString());
        System.out.println("Таблица успешно создана!");

    }

    public static void insertValues(Connection connection, String operation, String... numbers) throws SQLException {
        String insertQuery = String.format("INSERT INTO %s (%s, %s, %s, %s) VALUES (?, ?, ?, ?)", TABLE_NAME,
                COLUMN_NAMES[0], COLUMN_NAMES[1], COLUMN_NAMES[2], COLUMN_NAMES[3]);

        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

       // preparedStatement.setInt(1, ++counter);
        preparedStatement.setString(1, operation);
        preparedStatement.setString(2, numbers[0]);
        preparedStatement.setString(3, numbers[1]);
        preparedStatement.setString(4, numbers[2]);

        System.out.println(preparedStatement.toString());
        preparedStatement.executeUpdate();
        System.out.println("Результат успешно сохранен в базе данных!");
    }

    public static void saveToExcel(Connection connection) throws SQLException {
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(selectQuery);
        if (!resultSet.next()) {
            System.out.println("Table is empty");
            return;
        }
        StringBuilder line = new StringBuilder("");
        for (int i = 0; i < COLUMN_NAMES.length; i++) {
            line.append(COLUMN_NAMES[i] + " ");
        }
        System.out.println(line);
        do {
            line = new StringBuilder("");
            for (int i = 0; i < COLUMN_NAMES.length; i++) {
                var value = resultSet.getString(COLUMN_NAMES[i]);
                line.append(value + " ");
            }
            System.out.println(line);
        } while (resultSet.next());
    }

    public static void dropTable (Connection connection) throws SQLException {
        String query = "DROP TABLE " + TABLE_NAME;
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        System.out.println("Таблица успешно delete!");

    }

}
