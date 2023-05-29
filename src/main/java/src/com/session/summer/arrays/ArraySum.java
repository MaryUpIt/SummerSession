package src.com.session.summer.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArraySum implements InArray {
    @Override
    public int sumOfArrays(int[] firstArray, int[] secondArray) {
        int maxLength = Math.max(firstArray.length, secondArray.length);
        int[] arr1 = increaseArray(firstArray, maxLength);
        int[] arr2 = increaseArray(secondArray, maxLength);
        return IntStream.range(0, firstArray.length)
                .reduce(0, (sum, i) -> sum + (arr1[i] + arr2[i]));
    }
}
