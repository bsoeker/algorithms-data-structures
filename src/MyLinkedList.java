public class MyLinkedList<T> {

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
    }

    public void addFirst(T value) {
        Node node = new Node(value);

        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }

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
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }

        Node second = first.next;
        first.next = null;
        first = second;
    }

    public void removeLast() {
        // [first -> second -> third -> fourth]
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }

        if (first == last) {
            first = last = null;
            return;
        }

        Node current = first;
        while (current.next != last) // We have to get to the second to last item
            current = current.next;

        current.next = null;
        last = current;
    }

    public int size() {
        if (isEmpty())
            return 0;

        int counter = 0;
        Node current = first;

        while (current != null) {
            current = current.next;
            counter++;
        }

        return counter;
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
