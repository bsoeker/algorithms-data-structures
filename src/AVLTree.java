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

    private Node insert(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }

        if (value < node.value)
            node.leftChild = insert(value, node.leftChild);

        if (value > node.value)
            node.rightChild = insert(value, node.rightChild);

        node.height = Math.max(
                height(node.leftChild),
                height(node.rightChild)) + 1;

        if (isLeftHeavy(node)) {
            if (getBalanceFactor(node.leftChild) == 1)
                System.out.println("Needs a right rotation!");
            if (getBalanceFactor(node.rightChild) == -1)
                System.out.println("Needs a right-left rotation!");
        }
        if (isRightHeavy(node)) {
            if (getBalanceFactor(node.rightChild) == 1)
                // 10
                // -- 20
                // 15
                System.out.println("Needs a right-left rotation!");
            if (getBalanceFactor(node.rightChild) == -1)
                // 10
                // -- 20
                // ---- 30
                System.out.println("Needs a left rotation!");
        }
        return node; // Return the unchanged or updated node
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
}
