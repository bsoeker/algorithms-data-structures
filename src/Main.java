public class Main {

    public static void main(String[] args) {
        StackQueue<Integer> queue = new StackQueue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.dequeue();
        // queue.dequeue();
        // queue.dequeue();
        // queue.enqueue(30);
        // queue.enqueue(30);
        // queue.dequeue();
        // queue.enqueue(40);
        // queue.dequeue();
        // queue.enqueue(50);

        System.out.println(queue);
        System.out.println(queue);
        System.out.println(queue);
    }
}
