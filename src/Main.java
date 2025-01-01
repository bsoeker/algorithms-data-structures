public class Main {

    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue(10);
        queue.enqueue(3);
        queue.enqueue(1);
        queue.enqueue(-1);
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue);
    }
}
