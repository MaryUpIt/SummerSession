package src.com.session.summer.calculatorMySql;

import src.com.session.summer.view.Reader;

import java.sql.Connection;
import java.sql.SQLException;

import static src.com.session.summer.calculatorMySql.Operations.*;

public class Calculator {

    public static void calculate(Connection connection, Reader reader, Operations operator) throws SQLException, SQLException {
        Number firstNumber = getNumber(reader);
        if (operator == MODULUS) {
            double result = Math.abs(firstNumber.doubleValue());
            SqlRequests.insertValues(connection, MODULUS.toString(), firstNumber.toString(), String.valueOf(0), String.valueOf(result));
        }
        Number secondNumber = getNumber(reader);
        Number result = null;
        switch (operator) {
            case ADD, SUBTRACT -> result = operator == ADD ? firstNumber.doubleValue() + secondNumber.doubleValue() :
                    firstNumber.doubleValue() - secondNumber.doubleValue();
            case MULTIPLY -> {
                if (firstNumber instanceof Long && secondNumber instanceof Long) {
                    result = firstNumber.longValue() * secondNumber.longValue();
                } else {
                    result = firstNumber.doubleValue() * firstNumber.doubleValue();
                }
            }
            case DIV, MODULO_DIV -> {
                if (firstNumber instanceof Long && secondNumber instanceof Long && secondNumber.longValue() == 0) {
                    System.out.println("Division by zero impossible");
                    return;
                } else {
                    result = operator == DIV ? firstNumber.doubleValue() / secondNumber.doubleValue() :
                            firstNumber.doubleValue() % secondNumber.doubleValue();
                }
            }
            case POW -> result = Math.pow(firstNumber.doubleValue(), secondNumber.doubleValue());
        }
        SqlRequests.insertValues(connection, operator.toString(), firstNumber.toString(), secondNumber.toString(), String.valueOf(result));
    }


    private static Number getNumber(Reader reader) {
        System.out.print("Please input a number: ");
        try {
            return reader.getNumber();
        } catch (NumberFormatException e1) {
            System.out.println("Try Again");
            return getNumber(reader);
        }
    }

}

