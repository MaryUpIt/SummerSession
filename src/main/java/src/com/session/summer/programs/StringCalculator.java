package src.com.session.summer.programs;

import src.com.session.summer.view.Printer;
import src.com.session.summer.view.Reader;

import java.util.*;
import java.util.stream.IntStream;

public class StringCalculator extends SimplePrograms{
    private static final Map<Integer, String> numbersWords = new TreeMap<>();

    static {
        numbersWords.put(0, "ноль");
        numbersWords.put(1, "один");
        numbersWords.put(2, "два");
        numbersWords.put(3, "три");
        numbersWords.put(4, "четыре");
        numbersWords.put(5, "пять");
        numbersWords.put(6, "шесть");
        numbersWords.put(7, "семь");
        numbersWords.put(8, "восемь");
        numbersWords.put(9, "девять");
        numbersWords.put(10, "десять");
        numbersWords.put(11, "одиннадцать");
        numbersWords.put(12, "двенадцать");
        numbersWords.put(13, "тринадцать");
        numbersWords.put(14, "четырнадцать");
        numbersWords.put(15, "пятнадцать");
        numbersWords.put(16, "шестнадцать");
        numbersWords.put(17, "семнадцать");
        numbersWords.put(18, "восемнадцать");
        numbersWords.put(19, "девятнадцать");
        numbersWords.put(20, "двадцать");
        numbersWords.put(30, "тридцать");
        numbersWords.put(40, "сорок");
        numbersWords.put(50, "пятьдесят");
        numbersWords.put(60, "шестьдесят");
        numbersWords.put(70, "семьдесят");
        numbersWords.put(80, "восемьдесят");
        numbersWords.put(90, "девяносто");
        numbersWords.put(100, "сто");
    }

    public StringCalculator(Reader reader, Printer printer) {
        super(reader, printer);
    }

    public void execute() {
        String[] input = getInputLine();
        try {
            int a = getNumber(input[0]);
            int b = getNumber(input[2]);
            int result = calculate(input[1], a, b);
            System.out.println(covertToWord(result));

        } catch (IllegalArgumentException e) {
            System.out.println("Your input incorrect, try again!");
        }
    }

    private int calculate(String operator, int a, int b) {
        return switch (operator.toLowerCase()) {
            case "плюс" -> a + b;
            case "минус" -> a - b;
            case "умножить" -> a * b;
            default -> throw new IllegalStateException("incorrect input");
        };
    }

    private int getNumber(String value) {
        List<String> values = numbersWords.values().stream().toList();

        OptionalInt index = IntStream.range(0, values.size())
                .filter(i -> values.get(i).equals(value)).findFirst();
        if (index.isPresent()) {
            return index.getAsInt();
        }
        throw new IllegalArgumentException("incorrect input");
    }

    private String covertToWord(int number) {
        StringBuilder result = new StringBuilder(number < 0 ? "минус " : "");
        number = number < 0 ? -number : number;
        if (numbersWords.containsKey(number)) {
            return result.append(numbersWords.get(number)).toString();
        }
        int remainder = number % 10;
        int tens = number - remainder;
        return result.append(numbersWords.get(tens)).append(" ")
                .append(numbersWords.get(remainder)).toString();
    }

    private String[] getInputLine() {
        String[] input = reader.getText().split(" ");
        if (input.length != 3) {
            System.out.println("Your input incorrect, try again!");
            return getInputLine();
        }
        return input;
    }
}
