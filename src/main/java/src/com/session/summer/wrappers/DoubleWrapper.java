package src.com.session.summer.wrappers;

public class DoubleWrapper {

    private final double value;

    public DoubleWrapper(double value) {
        this.value = value;
    }

    public double valueOf() {
        return value;
    }

    public static DoubleWrapper power(DoubleWrapper base, DoubleWrapper exponent) {
        return new DoubleWrapper(Math.pow(base.valueOf(), exponent.valueOf()));
    }

    public static DoubleWrapper addition(DoubleWrapper first, DoubleWrapper second) {
        return new DoubleWrapper(first.valueOf() + second.valueOf());
    }

    public static DoubleWrapper division(DoubleWrapper first, DoubleWrapper second) {
        return new DoubleWrapper(first.valueOf() / second.valueOf());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj.getClass() != this.getClass() || obj == null) {
            return false;
        }
        DoubleWrapper that = (DoubleWrapper) obj;
        return this.value == that.value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
