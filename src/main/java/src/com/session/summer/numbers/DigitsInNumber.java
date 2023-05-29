package src.com.session.summer.numbers;

import src.com.session.summer.controlers.SimplePrograms;
import src.com.session.summer.view.Printer;
import src.com.session.summer.view.Reader;

import java.util.*;

public class DigitsInNumber extends SimplePrograms {
    public DigitsInNumber(Reader reader, Printer printer) {
        super(reader,printer);
    }

    @Override
    public void execute() {
        int number = getNumber(1, Integer.MAX_VALUE);
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
}
