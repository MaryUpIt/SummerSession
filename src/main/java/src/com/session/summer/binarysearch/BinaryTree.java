package src.com.session.summer.binarysearch;

public class BinaryTree<T extends Comparable<T>> {
    private static int size;
    private Node<T> root;

    public BinaryTree() {
        size = 0;
        root = null;
    }

    public static int size() {
        return size;
    }

    public void add(T value) {
        root = insertNode(root, value);
    }

    private Node<T> insertNode(Node<T> root, T value) {
        if (root == null) {
            root = new Node<>(value);
            size++;
            return root;
        }
        if (value.compareTo(root.value) < 0) {
            root.left = insertNode(root.left, value);
        } else if (value.compareTo(root.value) > 0) {
            root.right = insertNode(root.right, value);
        }
        return root;
    }

    public boolean isExist (T value) {
        return searchNode(root, value);
    }

    private boolean searchNode(Node<T> root, T value) {
        if (root == null) {
            return false;
        }
        if (value.compareTo(root.value) == 0) {
            return true;
        }
        if (value.compareTo(root.value) < 0) {
            return searchNode(root.left, value);
        } else {
            return searchNode(root.right, value);
        }
    }


    @Override
    public String toString() {
        StringBuilder tree = new StringBuilder("[");
        generateStringTree(root, tree);
        tree.replace(tree.length() - 2, tree.length(), "]");
        return tree.toString();
    }

    private void generateStringTree(Node<T> root, StringBuilder builder) {
        if (root != null) {
            generateStringTree(root.left, builder);
            builder.append(root.value + ", ");
            generateStringTree(root.right, builder);
        }
    }


    private class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;

        public Node(T value) {
            this.value = value;
            left = null;
            right = null;
        }

        @Override
        public String toString() {
            return "value: " + value+
                    ", left: " + (left == null ? "null" : left.value) +
                    ", right: " + (right == null ? "null" : right.value);
        }
    }
}

