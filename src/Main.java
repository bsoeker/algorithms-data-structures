public class Main {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(7);
        tree.insert(5);
        tree.insert(9);
        tree.insert(10);
        tree.insert(8);
        tree.insert(3);
        tree.insert(6);
        System.out.println(tree.contains(10));

        tree.inOrderTraverse();
    }
}
