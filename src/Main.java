public class Main {

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.insert(10);
        tree.insert(30);
        tree.insert(20);

        AVLTree tree2 = new AVLTree();
        tree2.insert(30);
        tree2.insert(20);
        tree2.insert(10);

        System.out.println();
    }
}
