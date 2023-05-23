package src.com.session.summer.programs;

import src.com.session.summer.view.Reader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersInString {
    private final Reader READER;

    public NumbersInString(Reader reader) {
        this.READER = reader;
    }

    public void execute() {
        int[] array = getNumbersFromString();
        System.out.println(array.length == 0 ? "There are no numbers in this line" :
                Arrays.toString(array));
    }

    private int[] getNumbersFromString() {
        String[] line = getString();
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

    private String[] getString () {
        System.out.print("Input your line: ");
        return READER.getText().split(" ");
    }


}
