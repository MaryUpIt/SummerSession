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
        int number = getNumber(1, 100);
        BinaryTree<Integer> binaryTree = generateBinaryTree();
        printLine(String.format("Random binary tree: %s", binaryTree.toString()));
        printLine(String.format("Binary tree %s a value %d",
                (binaryTree.isExist(number) ? "contain" : "not contain"),
                number));
    }

    private BinaryTree<Integer> generateBinaryTree() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();

        while (binaryTree.size() < 30) {
            binaryTree.add(Randomizer.generateRandomInt(1, 100));
        }
        return binaryTree;
    }




}
