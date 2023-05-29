public class MyMath {
    public static void main(String[] args) {
        System.out.println(Math.pow(2, 3.3));
        System.out.println(round(4.2));
        System.out.println(round(4.5));
        System.out.println(round(4.9));
    }

    public static double abs(double number) {
        return number < 0 ? -number : number;
    }

    public static int round(double number) {
        return number % 1 < 0.5 ? (int) number : (int) number + 1;
    }

    public static double pow(double number, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        boolean isNegative = exponent < 0;
        if (isNegative) {
            exponent = -exponent;
        }
        double result = 1;
        while (exponent > 0) {
            result *= number;
            exponent--;
        }
        return isNegative ? 1 / result : result;
    }
}
