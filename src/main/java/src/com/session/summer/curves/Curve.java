package src.com.session.summer.curves;

public abstract class Curve {
    protected final double [] parameters;

    protected Curve(double... parameters) {
        this.parameters = parameters;
    }

    protected abstract double function(double x);
}
