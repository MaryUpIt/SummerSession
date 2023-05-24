package src.com.session.summer.programs;

import src.com.session.summer.controlers.SimplePrograms;
import src.com.session.summer.util.Randomizer;
import src.com.session.summer.view.Printer;
import src.com.session.summer.view.Reader;

import java.util.Arrays;

public class SatanicRandomArray extends SimplePrograms {

    public SatanicRandomArray(Reader reader, Printer printer) {
        super(reader, printer);
    }

    @Override
    public void execute() {
        int height = getNumber(1, 10);
        int width = getNumber(1, 10);
        int [][]array = getFillArray(height,width,666);
        printArray(array);

    }

    private int[][] getFillArray(int height, int width, int satanic) {
        int[][] array = new int[height][width];
        int sum = 0;
        while (sum != satanic) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    int random = Randomizer.generateRandomInt(1, 100);
                    if (i == 0 || j == 0 || i == height - 1 || j == width - 1) {
                        sum -= array[i][j];
                        array[i][j] = random;
                        sum += random;
                        if (sum == satanic) {
                            return array;
                        }
                    } else {
                        array[i][j] = random;
                    }
                }
            }
        }
        return array;
    }


    private void printArray(int[][] array) {
        for (int[] element : array) {
            printLine(Arrays.toString(element));
        }
    }


}
