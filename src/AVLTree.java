public class AVLTree {
    private class Node {
        private int height;
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
        root = insert(value, root);
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

    private Node insert(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }

        if (value < node.value)
            node.leftChild = insert(value, node.leftChild);

        if (value > node.value)
            node.rightChild = insert(value, node.rightChild);

        return balance(node);
    }

    private Node balance(Node node) {
        if (isLeftHeavy(node)) {
            if (getBalanceFactor(node.leftChild) < 0)
                node.leftChild = rotateLeft(node.leftChild);

            return rotateRight(node);
        }

        if (isRightHeavy(node)) {
            if (getBalanceFactor(node.rightChild) > 0)
                node.rightChild = rotateRight(node.rightChild);

            return rotateLeft(node);
        }

        // If tree is already balanced:
        setHeight(node);
        return node;
    }

    private Node rotateLeft(Node node) {
        // ------ 10
        // --------- 20
        // ------ 15 -- 30

        Node newRoot = node.rightChild;
        node.rightChild = newRoot.leftChild;
        newRoot.leftChild = node;

        setHeight(node);
        setHeight(newRoot);

        return newRoot;
    }

    private Node rotateRight(Node node) {
        Node newRoot = node.leftChild;
        node.leftChild = newRoot.rightChild;
        newRoot.rightChild = node;

        setHeight(node);
        setHeight(newRoot);

        return newRoot;
    }

    private void setHeight(Node node) {
        node.height = Math.max(
                height(node.leftChild),
                height(node.rightChild)) + 1;
    }

    private int height(Node node) {
        return node == null ? -1 : node.height;
    }

    private int getBalanceFactor(Node node) {
        return node == null ? 0 : height(node.leftChild) - height(node.rightChild);
    }

    private boolean isLeftHeavy(Node node) {
        return getBalanceFactor(node) > 1;
    }

    private boolean isRightHeavy(Node node) {
        return getBalanceFactor(node) < -1;
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
