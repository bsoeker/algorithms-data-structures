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

    private static final int[] PRIMES = { 101, 211, 431, 863, 1741, 3499, 7013, 14033 };
    private int primeIndex = 0;
    private LinkedList<Entry>[] arr;
    private int size;
    private final double loadFactorThreshold;

    @SuppressWarnings("unchecked")
    public HashTable() {
        this.arr = (LinkedList<Entry>[]) new LinkedList[PRIMES[primeIndex++]];
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
        if (primeIndex == PRIMES.length) {
            System.out.println("Already at the biggest available prime size!");
            return;
        }

        @SuppressWarnings("unchecked")
        LinkedList<Entry>[] newArr = new LinkedList[PRIMES[primeIndex++]];

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
