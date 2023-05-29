package src.com.session.summer.binarysearch;

import src.com.session.summer.controlers.SimplePrograms;
import src.com.session.summer.util.Randomizer;
import src.com.session.summer.view.Printer;
import src.com.session.summer.view.Reader;

public class BinarySearchExecutor extends SimplePrograms {

    public BinarySearchExecutor(Reader reader, Printer printer) {
        super(reader, printer);
    }

    @Override
    public void execute() {
        int size = getNumber("Input list size: ");
        int minValue = getNumber("Input min value: ");
        int maxValue = getNumber("Input max value: ");
        int number = getNumber( minValue, maxValue);
        BinaryTree<Integer> binaryTree = generateBinaryTree(size,minValue,maxValue);
        printLine(String.format("Random binary tree: %s", binaryTree.toString()));
        printLine(String.format("Binary tree %s a value %d",
                (binaryTree.isExist(number) ? "contain" : "not contain"),
                number));
    }

    private BinaryTree<Integer> generateBinaryTree(int size, int minValue, int maxvalue) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();

        while (binaryTree.size() < size) {
            binaryTree.add(Randomizer.generateRandomInt(minValue, maxvalue));
        }
        return binaryTree;
    }




}
