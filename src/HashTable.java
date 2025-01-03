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

    private boolean isBucketEmpty(int index) {
        return arr[index] == null;
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % arr.length;
    }

    @SuppressWarnings("unchecked")
    public HashTable() {
        this.arr = (LinkedList<Entry>[]) new LinkedList[29];
    }

    public void add(K key, V value) {
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
    }

    public V get(K key) {
        int index = getIndex(key);
        if (isBucketEmpty(index)) {
            return null;
        }

        // Search for the key in the list
        for (Entry entry : arr[index]) {
            if (entry.key == key) {
                return entry.value;
            }
        }

        return null;
    }
}
