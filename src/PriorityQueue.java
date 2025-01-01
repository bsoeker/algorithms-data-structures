import java.util.Arrays;

public class PriorityQueue {
    private int[] arr;
    private int rear;
    private int front;

    public PriorityQueue(int size) {
        arr = new int[size];
    }

    private void increaseSize() {
        int[] newArr = new int[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        this.arr = newArr;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return rear == arr.length;
    }

    public void enqueue(int value) {
        if (isFull())
            increaseSize();

        if (isEmpty()) {
            arr[rear++] = value;
            return;
        }

        int i;
        for (i = rear; i > front; i--) {
            if (value < arr[i - 1]) {
                arr[i] = arr[i - 1];
                continue;
            }
        }

        arr[i] = value;
        rear++;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty!");

        return arr[front++];
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(arr, front, rear));
    }
}
