package src.com.session.summer.numbers;

import java.util.Arrays;

public class Binary {

    public static long getNumber(char[] binaryNumber) {
        if (binaryNumber[0] == '0') {
            return getResult(binaryNumber);
        }
        binaryNumber = negativeBinaryNumber(binaryNumber);
        return - getResult(binaryNumber);
}

    public static char[] getBinaryNumber(long number) {
        int length = range(number);
        char[] binaryNumber = new char[length];
        Arrays.fill(binaryNumber, '0');
        long tmp = Math.abs(number);
        int index = length - 1;
        while (tmp > 0) {
            binaryNumber[index] = (char) (tmp % 2 + '0');
            tmp /= 2;
            index--;
        }
        if (number < 0) {
            return negativeBinaryNumber(binaryNumber);
        }
        return binaryNumber;
    }

    private static long getResult(char[] binaryNumber) {
        long result = 0;
        int index = binaryNumber.length - 1;
        for (int i = 0; i < binaryNumber.length - 1; i++) {
            if (binaryNumber[index - i] == '1') {
                result += Math.pow(2, i);
            }
        }
        return result;
    }

    private static char[] negativeBinaryNumber(char[] binaryNumber) {
        char[] negative = negativeBinaryArray(binaryNumber);
        int i = negative.length - 1;
        while (negative[i] == '1') {
            negative[i] = '0';
            i--;
        }
        negative[i] = '1';
        return negative;
    }

    private static char[] negativeBinaryArray(char[] binaryNumber) {
        char[] negative = new char[binaryNumber.length];
        for (int i = 0; i < negative.length; i++) {
            negative[i] = binaryNumber[i] == '0' ? '1' : '0';
        }
        return negative;
    }


    private static int range(long number) {
        if (number >= Byte.MIN_VALUE && number <= Byte.MAX_VALUE) {
            return 8;
        }
        if (number >= Short.MIN_VALUE && number <= Short.MAX_VALUE) {
            return 16;
        }
        if (number >= Integer.MIN_VALUE && number <= Integer.MAX_VALUE) {
            return 32;
        }
        if (number >= Long.MIN_VALUE && number <= Long.MAX_VALUE) {
            return 64;
        }
        return 0;
    }
}
