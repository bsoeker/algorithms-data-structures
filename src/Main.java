import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Heap heap = new Heap();
        List<Integer> numbers = List.of(1, 2, 43, 4536, 123, 567, 45, 26, 756);
        for (Integer number : numbers) {
            heap.insert(number);
        }

        List<Integer> sorted = new ArrayList<>();
        while (!heap.isEmpty())
            sorted.addFirst(heap.remove());
        // or use sorted.add(heap.remove()) for descending order!

        System.out.println(sorted);

    }
}
