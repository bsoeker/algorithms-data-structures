import java.util.NoSuchElementException;

public class BinarySearchTree {
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        private Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return Integer.toString(value);
        }
    }

    private Node root;

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }

        Node current = root;
        Node parent = null;
        while (current != null) {
            parent = current;
            if (value < current.value)
                current = current.leftChild;
            else if (value > current.value)
                current = current.rightChild;

            // If the value already exists, we return silently.
            else
                return;
        }

        // Now that the parent is pointing to the correct node, we can place the new
        // value.
        if (value < parent.value) {
            parent.leftChild = new Node(value);
            return;
        } else {
            parent.rightChild = new Node(value);
            return;
        }
    }

    public boolean contains(int value) {
        if (root == null)
            return false;

        Node current = root;
        while (current != null) {
            if (value < current.value)
                current = current.leftChild;
            else if (value > current.value)
                current = current.rightChild;
            else
                return true;
        }

        return false;
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null)
            return -1;

        if (node.leftChild == null && node.rightChild == null)
            return 0;

        return 1 + Math.max(height(node.leftChild), height(node.rightChild));
    }

    public int minValue() {
        if (root == null)
            throw new NoSuchElementException("Tree is empty!");

        return minValue(root);
    }

    // If the tree is a BST, the cost of this algorithm is the lowest.
    private int minValueIterative() {
        Node current = root;
        while (current.leftChild != null)
            current = current.leftChild;

        return current.value;
    }

    private int minValueRecursive(Node node) {
        if (node == null)
            return Integer.MAX_VALUE;

        return Math.min(node.value, minValueRecursive(node.leftChild));
    }

    // This implementation will work with any kind of binary tree
    // O(n)
    private int minValue(Node node) {
        if (node == null)
            return Integer.MAX_VALUE;

        int left = minValue(node.leftChild);
        int right = minValue(node.rightChild);

        return Math.min(Math.min(left, right), node.value);
    }

    @Override
    public boolean equals(Object other) {
        // Inline casting example
        if (!(other instanceof BinarySearchTree bst))
            return false;

        return equals(root, bst.root);
    }

    private boolean equals(Node first, Node second) {
        if (first == null && second == null)
            return true;

        if (first != null && second != null)
            return first.value == second.value
                    && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, second.rightChild);

        return false;
    }

    public void preOrderTraverse() {
        preOrderTraverse(root);
    }

    public void inOrderTraverse() {
        inOrderTraverse(root);
    }

    public void postOrderTraverse() {
        postOrderTraverse(root);
    }

    private void preOrderTraverse(Node node) {
        if (node == null)
            return;

        System.out.println(node);
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    }

    private void inOrderTraverse(Node node) {
        if (node == null)
            return;

        inOrderTraverse(node.leftChild);
        System.out.println(node);
        inOrderTraverse(node.rightChild);
    }

    private void postOrderTraverse(Node node) {
        if (node == null)
            return;

        postOrderTraverse(node.leftChild);
        postOrderTraverse(node.rightChild);
        System.out.println(node);
    }
}
