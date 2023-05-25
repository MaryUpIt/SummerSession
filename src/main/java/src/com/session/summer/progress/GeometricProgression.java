package src.com.session.summer.progress;


public class GeometricProgression implements Progress {

    private final double start;
    private final double step;

    public GeometricProgression(double start, double step) {
        this.start = start;
        this.step = step;
    }

    @Override
    public double getElementAtIndex(int index) {
        return start * Math.pow(step, index);
    }

    @Override
    public double sumOfProgression(int index) {
        return (getElementAtIndex(index) * step - start) / (step - 1);
    }
}
