public class Main {

    public static void main(String[] args) {
        HashTable<Integer, String> table = new HashTable<>();
        for (int i = 0; i < 100; i++) {
            table.add(i, "Hellooo");
        }

        System.out.println(table.size());
        System.out.println(table.get(78));
    }
}
