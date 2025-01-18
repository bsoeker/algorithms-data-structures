public class Main {

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.insert(10);
        tree.insert(30);
        tree.insert(20);
        tree.insert(20);
        tree.insert(40);
        tree.insert(50);

        // ----------10 ------------ 20 ------------------ 20
        // ------------30 ---------10 - 30 -------------10 -- 40
        // ----------20 ----------------- 40 ---------------30 - 50
        // -------------------------------- 50
        tree.preOrderTraverse();
        System.out.println();
        tree.postOrderTraverse();
    }
}
