public class Main {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(7);
        tree.insert(9);
        tree.insert(8);
        tree.insert(5);
        tree.insert(10);
        tree.insert(2);
        tree.insert(6);
        tree.insert(1);
        tree.insert(-1);

        BinarySearchTree secondTree = new BinarySearchTree();
        secondTree.insert(7);
        secondTree.insert(9);
        secondTree.insert(8);
        secondTree.insert(5);
        secondTree.insert(10);
        secondTree.insert(2);
        secondTree.insert(6);
        secondTree.insert(1);
        secondTree.insert(-1);

        System.out.println(tree.equals(secondTree));
    }
}
