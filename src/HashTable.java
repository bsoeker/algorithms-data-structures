// for now i won't implement a generic class due to the complications in
// implementing a general hash function.

public class HashTable {
    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] arr;

    private boolean isBucketEmpty(int index) {
        return arr[getIndex(index)] == null;
    }

    private int getIndex(int key) {
        return Math.abs(key) % arr.length;
    }

    @SuppressWarnings("unchecked")
    public HashTable() {
        this.arr = (LinkedList<Entry>[]) new LinkedList[29];
    }

    public void add(int key, String value) {
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

    public String get(int key) {
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
