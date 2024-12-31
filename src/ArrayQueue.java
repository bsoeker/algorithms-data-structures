import java.util.StringJoiner;

public class ArrayQueue {
    private int[] arr;
    private int front;
    private int rear;
    private int count;

    public ArrayQueue(int size) {
        arr = new int[size];
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return count == arr.length;
    }

    public void enqueue(int value) {
        if (isFull())
            throw new IllegalStateException("Queue is full!");

        arr[rear % arr.length] = value; // Instead of allocating more memory each time the rear
        // reaches the length of the arr we can make use of the slots of the dequeued
        // values by using circular arrays via the modulus operator!
        rear++;
        count++;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty!");

        int item = arr[front % arr.length];
        front++;
        count--;
        return item;
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "[ ]";

        StringJoiner joiner = new StringJoiner(", ", "[ ", " ]");
        for (int i = front; i < rear; i++) {
            joiner.add(String.valueOf(arr[i % arr.length]));
        }

        return joiner.toString();
    }
}
