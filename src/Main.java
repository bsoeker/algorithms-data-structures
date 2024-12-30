public class Main {

    public static void main(String[] args) {
        MyLinkedList<Integer> intList = new MyLinkedList<>();
        intList.addLast(10);
        intList.addLast(20);
        intList.addLast(30);
        intList.addLast(40);
        intList.addLast(50);
        // intList.reverse();
        System.out.println(intList.KthNodeFormTheEnd(5));

        System.out.println(intList);
    }
}
