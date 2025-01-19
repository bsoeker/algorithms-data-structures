import java.util.Arrays;

public class Heap {
    private int[] arr;
    private int size;

    public Heap() {
        arr = new int[16];
    }

    public void insert(int value) {
        if (isFull())
            increaseSize();

        arr[size] = value;
        int pointer = size;

        // bubble up
        while (pointer != 0) { // pointer = 0 means its parent will be out of bounds!
            int parentIndex = (pointer - 1) / 2;
            if (arr[pointer] > arr[parentIndex]) {
                swap(pointer, parentIndex);
                pointer = parentIndex;
                continue;
            } else
                break;
        }

        size++;
        return;
    }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException("Heap is empty!");

        // We should replace the root with the last item and bubble it down to the
        // correct place
        int rootIndex = 0;
        int popped = arr[rootIndex];
        arr[rootIndex] = arr[--size];

        // bubble down
        while (!isValidParent(rootIndex)) {
            int leftChildIndex = rootIndex * 2 + 1;
            int rightChildIndex = rootIndex * 2 + 2;

            if (!hasRightChild(rootIndex)) {
                swap(rootIndex, leftChildIndex);
                rootIndex = leftChildIndex;
                continue;
            }

            int biggerChildIndex = getBiggerChildIndex(leftChildIndex, rightChildIndex);
            swap(rootIndex, biggerChildIndex);
            rootIndex = biggerChildIndex;
            continue;
        }

        return popped;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index))
            return true;

        if (!hasRightChild(index))
            return arr[index] >= arr[index * 2 + 1];

        return arr[index] >= arr[index * 2 + 1] && arr[index] >= arr[index * 2 + 2];
    }

    private boolean hasLeftChild(int index) {
        return index * 2 + 1 < size;
    }

    private boolean hasRightChild(int index) {
        return index * 2 + 2 < size;
    }

    private int getBiggerChildIndex(int leftChildIndex, int rightChildIndex) {
        return arr[leftChildIndex] >= arr[rightChildIndex] ? leftChildIndex : rightChildIndex;
    }

    private void swap(int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private void increaseSize() {
        int[] newArr = new int[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        arr = newArr;
    }

    private boolean isFull() {
        return size == arr.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(arr, 0, size));
    }
}
