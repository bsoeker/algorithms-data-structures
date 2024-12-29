public class Main {

	public static void main(String[] args) {
		MyLinkedList<Integer> list = new MyLinkedList<>();
		// list.addLast(10);
		// list.addLast(20);
		list.addLast(30);
		list.addFirst(5);
		list.addFirst(1);
		System.out.println(list);
		System.out.println(list.indexOf(1));
		System.out.println(list.indexOf(5));
		System.out.println(list.contains(30));
	}
}
