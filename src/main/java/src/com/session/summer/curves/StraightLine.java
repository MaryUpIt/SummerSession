package src.com.session.summer.curves;

public class StraightLine extends Curve {

    protected StraightLine(double a, double b) {
        super(a, b);
    }

    @Override
    protected double function(double x) {
        double a = parameters[0];
        double b = parameters[1];
        return a * x + b;
    }
}
