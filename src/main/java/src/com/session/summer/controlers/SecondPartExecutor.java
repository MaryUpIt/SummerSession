package src.com.session.summer.controlers;

import src.com.session.summer.programs.Factorial;
import src.com.session.summer.programs.SatanicRandomArray;
import src.com.session.summer.triangle.TriangleExecute;
import src.com.session.summer.view.Printer;
import src.com.session.summer.view.Reader;
import src.com.session.summer.wrappers.DoubleWrapperExecute;

public class SecondPartExecutor extends MenuExecutor{
    private final String MENU = """            
            Select an command from the menu:
            1. Factorial of number
            2. Create class double wrapper
            3. Fill 2-d array random numbers
            4. Triangle and right triangle
            5. straight line and parabola equations
            6. interface Progress
            7. interface inArray
            8. class Binary
            9. class Matrix
            10. class MyMath
            11. Prev tasks
            12. Next tasks
            Your input:  
            """;

    protected SecondPartExecutor(Reader reader, Printer printer) {
        super(reader, printer);
    }

    @Override
    protected void executeMenuItem() {
            int input = getInputNumber(MENU);
            Executor executor = switch (input) {
                case 1 -> new Factorial(reader, printer);
                case 2 -> new DoubleWrapperExecute(reader, printer);
                case 3 -> new SatanicRandomArray(reader,printer);
                case 4 -> new TriangleExecute(reader, printer);
//                case 5 -> new BinarySearchExecutor(reader,printer);
//                case 6 -> new EnglishAlphabet(printer);
//                case 7 -> new AnyTimesPrinter(reader,printer);
//                case 8 -> new Cubes(printer);
//                case 9 -> new DayOfWeek(reader, printer);
//                case 10 -> new WeekNumber(reader, printer);
                case 11 -> new FirstPartExecutor(reader, printer);
        //        case 12 ->
                default -> null;
            };
            if (executor != null) {
                executor.execute();
            } else {
                printer.printNewLine("it's not command");
            }
    }
}
