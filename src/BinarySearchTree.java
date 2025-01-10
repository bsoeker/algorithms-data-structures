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
