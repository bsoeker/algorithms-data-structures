import java.util.NoSuchElementException;

public class HashTable<K, V> {
    private class Entry {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] arr;
    private int size;
    private final double loadFactorThreshold;

    @SuppressWarnings("unchecked")
    public HashTable() {
        this.arr = (LinkedList<Entry>[]) new LinkedList[29];
        this.size = 0;
        this.loadFactorThreshold = 0.75;
    }

    private boolean isThresholdExceeded() {
        return (double) size / arr.length > loadFactorThreshold;
    }

    private boolean isBucketEmpty(int index) {
        return arr[index] == null;
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % arr.length;
    }

    private void increaseSize() {
        @SuppressWarnings("unchecked")
        LinkedList<Entry>[] newArr = new LinkedList[arr.length * 2];

        // Rehashing the existing elements in the new hashTable
        for (LinkedList<Entry> bucket : arr) {
            if (bucket != null) {
                for (Entry entry : bucket) {
                    int newIndex = getIndex(entry.key);

                    if (newArr[newIndex] == null)
                        newArr[newIndex] = new LinkedList<>();

                    newArr[newIndex].addLast(entry);
                }
            }
        }

        arr = newArr;
        return;
    }

    public int size() {
        return size;
    }

    public void add(K key, V value) {
        if (isThresholdExceeded())
            increaseSize();

        int index = getIndex(key);
        if (isBucketEmpty(index)) {
            arr[index] = new LinkedList<>();
        }

        // Check if the key already exists
        for (Entry entry : arr[index]) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }

        arr[index].addLast(new Entry(key, value));
        size++;
    }

    public V get(K key) {
        int index = getIndex(key);
        if (isBucketEmpty(index))
            return null;

        // Search for the key in the list
        for (Entry entry : arr[index]) {
            if (entry.key == key) {
                return entry.value;
            }
        }

        return null;
    }

    public void remove(K key) {
        int index = getIndex(key);
        if (isBucketEmpty(index))
            throw new NoSuchElementException();

        for (Entry entry : arr[index]) {
            if (entry.key == key) {
                arr[index].removeByValue(entry);
                size--;
                return;
            }
        }

        throw new NoSuchElementException();
    }
}
