package src.com.session.summer.curves;

public class Parabola extends Curve {

    protected Parabola(double a, double b, double c) {
        super(a, b, c);
    }

    @Override
    protected double function(double x) {
        double a = parameters[0];
        double b = parameters[1];
        double c = parameters[3];
        return a * Math.pow(x, 2) + b * x + c;
    }
}
