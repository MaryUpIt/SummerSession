package src.com.session.summer.programs;

import src.com.session.summer.view.Executor;
import src.com.session.summer.view.Printer;
import src.com.session.summer.view.Reader;

import java.util.*;

public class DigitsInNumber extends SimplePrograms {
    public DigitsInNumber(Reader reader, Printer printer) {
        super(reader,printer);
    }

    @Override
    public void execute() {
        int number = getNaturalNumber();
        System.out.println(Arrays.toString(getDigits(number)));
    }

    private int[] getDigits(int number) {
        List<Integer> list = new LinkedList<>();
        while (number > 0) {
            list.add(0, number % 10);
            number /= 10;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private int getNaturalNumber() {
        System.out.print("Input a number: ");
        try {
            int number = reader.getIntNumber();
            if (number <= 0) {
                System.out.println("It's not a natural number, try again!");
                return getNaturalNumber();
            }
            return number;

        } catch (NumberFormatException e) {
            System.out.println("It's not a number, try again!");
            return getNaturalNumber();
        }
    }


}
