public class Main {

    public static void main(String[] args) {
        MyLinkedList<Integer> intList = new MyLinkedList<>();
        intList.addLast(10);
        intList.addLast(20);
        intList.addLast(30);
        intList.addLast(30);
        intList.addLast(30);
        intList.reverse();

        System.out.println(intList);
    }
}
