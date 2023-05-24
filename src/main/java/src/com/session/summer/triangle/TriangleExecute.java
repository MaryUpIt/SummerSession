package src.com.session.summer.triangle;

import src.com.session.summer.controlers.MenuExecutor;
import src.com.session.summer.view.Printer;
import src.com.session.summer.view.Reader;

public class TriangleExecute extends MenuExecutor {
    String MENU = """
            This is Triangle classes you can:
            1. Create Triangle
            2. Create Right Triangle
            Your input:
            """;

    String NEXT = """
            This is Triangle classes you can:
            1. Find perimeter of triangle
            2. Find area of triangle
            Your input:
            """;

    public TriangleExecute(Reader reader, Printer printer) {
        super(reader, printer);
    }

    @Override
    protected void executeMenuItem() {
        int input = getInputNumber(MENU);
        switch (input) {
            case 1, 2 -> execute(createTriangle(input));
            default -> printer.printNewLine("it's not command");
        }

    }

    private Triangle createTriangle(int input) {
        double side1 = getDoubleNumber();
        double side2 = getDoubleNumber();
        if (input == 1) {
            double side3 = getDoubleNumber();
            Triangle triangle = new Triangle(side1, side2, side3);
            if (!triangle.isExist()) {
                printer.printNewLine("This triangle is impossible");
                return createTriangle(input);
            }
            return triangle;
        }
        if (input == 2) {
            return new RightTriangle(side1, side2);
        }
        return null;
    }

    private void execute(Triangle triangle) {
        if (triangle != null) {
            int input = getInputNumber(NEXT);
            switch (input) {
                case 1 -> printer.printNewLine("Perimeter: " + triangle.getPerimeter());
                case 2 -> printer.printNewLine("Area: " + triangle.getArea());
                default -> printer.printNewLine("it's not command");
            }
            if (isNext("")) {
                execute(triangle);
            }
        }
    }
}
