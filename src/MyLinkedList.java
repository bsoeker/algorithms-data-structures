import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T> {

    private class Node {
        T value;
        Node next;

        private Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node first;
    private Node last;
    private int size;

    private boolean isEmpty() {
        return first == null;
    }

    public void addLast(T value) {
        Node node = new Node(value);

        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }

        size++;
    }

    public void addFirst(T value) {
        Node node = new Node(value);

        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }

        size++;
    }

    public int indexOf(T value) {
        Node current = first;
        int index = 0;

        while (current != null) {
            if (current.value == value)
                return index;
            current = current.next;
            index++;
        }

        return -1;
    }

    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

    public void removeFirst() {
        // [first -> second -> third]
        if (isEmpty())
            throw new NoSuchElementException("List is empty!");

        Node second = first.next;
        first.next = null;
        first = second;
        size--;
    }

    public void removeLast() {
        // [first -> second -> third -> last]
        if (isEmpty())
            throw new NoSuchElementException("List is empty!");

        if (first == last) {
            first = last = null;
            size--;
            return;
        }

        Node current = first;
        while (current.next != last) // We have to get to the second to last item
            current = current.next;

        current.next = null;
        last = current;
        size--;
    }

    public void reverse() {
        // [10 -> 20 -> 30 -> 40]
        // p -> c -> n

        Node previous = first;
        Node current = first.next;

        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;
    }

    public T KthNodeFormTheEnd(int k) {
        if (k <= 0)
            throw new IllegalArgumentException("k must be at least 1!");

        Node headPointer = first;
        Node tailPointer = first;

        int distanceBetween = k - 1;

        while (distanceBetween != 0) {
            tailPointer = tailPointer.next;
            distanceBetween--;
        }

        while (tailPointer.next != null) {
            tailPointer = tailPointer.next;
            headPointer = headPointer.next;
        }

        return headPointer.value;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext())
                    throw new NoSuchElementException();

                T value = current.value;
                current = current.next;
                return value;
            }
        };
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "[ ]";

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[ ");

        Node current = first;
        while (current != null) {
            stringBuffer.append(current.value + ", ");
            current = current.next;
        }

        stringBuffer.deleteCharAt(stringBuffer.length() - 1 - 1);
        stringBuffer.append("]");

        return stringBuffer.toString();
    }
}
