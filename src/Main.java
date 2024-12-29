public class Main {

    public static void main(String[] args) {
        // MyLinkedList<Integer> intList = new MyLinkedList<>();
        // intList.addLast(10);
        // intList.addLast(20);
        // intList.addLast(30);
        // intList.addLast(40);
        // intList.addLast(10);
        // System.out.println(intList.size());
        // for (Integer integer : intList) {
        // System.out.println(integer);
        // }
        //
        // System.out.println(intList);

        MyLinkedList<String> cities = new MyLinkedList<>();
        cities.addLast("New York");
        cities.addLast("Paris");
        cities.addLast("Tokyo");
        cities.addLast("Moscow");
        cities.removeLast();

        System.out.println(cities);
        for (String city : cities) {
            System.out.println(city);
        }

        MyLinkedList<MyLinkedList<Integer>> lists = new MyLinkedList<>();
        lists.addLast(new MyLinkedList<Integer>());
        lists.addLast(new MyLinkedList<Integer>());

        for (var list : lists) {
            list.addLast(10);
            list.addLast(20);
        }

        for (var list : lists) {
            for (var number : list) {
                System.out.println(number);
            }
        }
    }
}
