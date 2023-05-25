package src.com.session.summer.progress;

public class ArithmeticProgression implements Progress {

    private final double start;
    private final double step;

    public ArithmeticProgression(int start, int step) {
        this.step = step;
        this.start = start;
    }

    @Override
    public double getElementAtIndex(int index) {
        return start + index * step;
    }

    @Override
    public double sumOfProgression(int index) {
        return (index + 1) * (start + getElementAtIndex(index)) / 2;
    }
}
