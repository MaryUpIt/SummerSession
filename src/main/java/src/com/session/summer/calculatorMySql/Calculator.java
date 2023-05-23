package src.com.session.summer.calculatorMySql;

import static src.com.session.summer.calculatorMySql.Operations.*;

public class Calculator {
    public static Number calculate(Operations operation, Number... numbers) throws ArithmeticException{

        Number first = numbers[0];
        Number second = numbers.length == 2 ? numbers[1] : 0;
        return switch (operation) {
            case ADD, SUBTRACT -> operation == ADD ? first.doubleValue() + second.doubleValue() :
                    first.doubleValue() - second.doubleValue();
            case MULTIPLY -> isLongNumbers(first, second) ? first.longValue() * second.longValue() :
                    first.doubleValue() * second.doubleValue();
            case DIV, MODULO_DIV -> division(operation, first, second);
            case MODULUS -> Math.abs(first.doubleValue());
            case POW -> Math.pow(first.doubleValue(), second.doubleValue());
        };
    }

    private static Number division(Operations operation, Number first, Number second) {
        if (isLongNumbers(first, second) && second.longValue() != 0) {
            throw new ArithmeticException("Division by zer0");
        }
        return operation == DIV ? first.doubleValue() / second.doubleValue() :
                        first.doubleValue() % second.doubleValue();
    }

    private static boolean isLongNumbers(Number first, Number second) {
        return first instanceof Long && second instanceof Long;
    }

}
//    private final Reader reader;
//   // private final Printer printer;
//    private final SqlRequests requests;
//
//    public Calculator(Reader reader, Printer printer, SqlRequests requests) {
//        this.requests = requests;
//    }
//
//
//    public  Number calculate(Operations operator) throws SQLException, SQLException {
//        Number firstNumber = getNumber(reader);
//        Number result = null;
//        if (operator == MODULUS) {
//            result = Math.abs(firstNumber.doubleValue());
//            requests.insertValues(MODULUS.toString(), firstNumber.toString(), String.valueOf(0), String.valueOf(result));
//        }
//        Number secondNumber = getNumber(reader);
//        switch (operator) {
//            case ADD, SUBTRACT -> result = operator == ADD ? firstNumber.doubleValue() + secondNumber.doubleValue() :
//                    firstNumber.doubleValue() - secondNumber.doubleValue();
//            case MULTIPLY -> {
//                if (firstNumber instanceof Long && secondNumber instanceof Long) {
//                    result = firstNumber.longValue() * secondNumber.longValue();
//                } else {
//                    result = firstNumber.doubleValue() * firstNumber.doubleValue();
//                }
//            }
//            case DIV, MODULO_DIV -> {
//                if (firstNumber instanceof Long && secondNumber instanceof Long && secondNumber.longValue() == 0) {
//                    return null;
//                } else {
//                    result = operator == DIV ? firstNumber.doubleValue() / secondNumber.doubleValue() :
//                            firstNumber.doubleValue() % secondNumber.doubleValue();
//                }
//            }
//            case POW -> result = Math.pow(firstNumber.doubleValue(), secondNumber.doubleValue());

//        requests.insertValues(operator.toString(), firstNumber.toString(), secondNumber.toString(), String.valueOf(result));
//        return result;
//    }
//    private  Number getNumber(Reader reader) {
//        System.out.print("Please input a number: ");
//        try {
//            return reader.getNumber();
//        } catch (NumberFormatException e1) {
//            System.out.println("Try Again");
//            return getNumber(reader);
//        }
//    }



