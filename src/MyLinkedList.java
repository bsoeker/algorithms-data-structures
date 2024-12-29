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

	public void addLast(T value) {
		Node node = new Node(value);

		if (first == null)
			first = last = node;
		else {
			last.next = node;
			last = node;
		}
	}

	public void addFirst(T value) {
		Node node = new Node(value);

		if (first == null)
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

	@Override
	public String toString() {
		if (first == null)
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
