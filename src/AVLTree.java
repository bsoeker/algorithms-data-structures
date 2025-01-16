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

        return node; // Return the unchanged or updated node
    }

    private int height(Node node) {
        return node == null ? -1 : node.height;
    }
}
