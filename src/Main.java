import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < 20; i++) {
            queue.add(i);
        }

        QueueReverser.reverse(queue);
        System.out.println(queue);
    }
}
