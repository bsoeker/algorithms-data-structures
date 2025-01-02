public class Main {

    public static void main(String[] args) {
        HashTable table = new HashTable();

        table.add(1, "New York");
        table.add(1, "Tokyo");
        table.add(-1, "Istanbul");
        table.add(30, "New York");
        System.out.println(table.get(-1));
        System.out.println(table.get(1));
        System.out.println(table.get(30));
    }
}
