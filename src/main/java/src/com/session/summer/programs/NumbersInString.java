package src.com.session.summer.programs;

import src.com.session.summer.controlers.SimplePrograms;
import src.com.session.summer.view.Printer;
import src.com.session.summer.view.Reader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersInString extends SimplePrograms {
    public NumbersInString(Reader reader, Printer printer) {
        super(reader, printer);
    }

    @Override
    public void execute() {
        int[] array = getNumbersFromString();
        System.out.println(array.length == 0 ? "There are no numbers in this line" :
                Arrays.toString(array));
    }

    private int[] getNumbersFromString() {
        String[] line = getLine("Input your line: ").split(" ");
        List<Integer> list = new ArrayList<>();
        for (String element : line) {
            try {
                int number = Integer.parseInt(element);
                list.add(number);
            } catch (NumberFormatException e) {
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
