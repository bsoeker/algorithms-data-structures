import java.util.Arrays;

public class Stack<T> {
    private T[] arr;
    private int pointer;

    @SuppressWarnings("unchecked")
    public Stack() {
        this.arr = (T[]) new Object[16];
        this.pointer = 0;
    }

    private void increaseSize() {
        @SuppressWarnings("unchecked")
        T[] newArr = (T[]) new Object[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        this.arr = newArr;
    }

    public void push(T value) {
        if (pointer == arr.length)
            increaseSize();

        arr[pointer++] = value;
    }

    public T pop() {
        if (isEmpty())
            throw new IllegalStateException("Stack is empty!");

        return arr[--pointer];
    }

    public int size() {
        return pointer;
    }

    public boolean isEmpty() {
        return pointer == 0;
    }

    public Stack<T> createCopy() {
        Stack<T> copy = new Stack<>();
        for (int i = 0; i < pointer; i++) {
            copy.push(arr[i]);
        }

        return copy;
    }

    public T peek() {
        if (isEmpty())
            throw new IllegalStateException("Stack is empty!");

        return arr[pointer - 1];
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(arr, pointer));
    }
}
