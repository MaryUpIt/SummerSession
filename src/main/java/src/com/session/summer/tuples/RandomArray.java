package src.com.session.summer.tuples;

import src.com.session.summer.util.Randomizer;
import src.com.session.summer.view.Printer;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RandomArray {

    public static void printFirstTenNumbers() {
        int [] array = generateRandomArray(100, 0, 100);
        Arrays.sort(array);
        IntStream.range(0,10).forEach(i -> System.out.println(array[i]));
    }

    private static int[] generateRandomArray(int length, int minValue, int maxValue) {
        return IntStream.range(0, length)
                .map(i -> Randomizer.generateRandomInt(minValue, maxValue)).toArray();
    }
}
