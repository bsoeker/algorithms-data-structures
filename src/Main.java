public class Main {

	public static void main(String[] args) {
		CustomArray arr = new CustomArray(5);
		arr.insert(1);
		arr.insert(2);
		arr.insert(3);
		arr.insert(4);
		arr.insert(5);
		arr.removeAt(0);
		System.out.println(arr);
		System.out.println(arr.indexOf(1));

		arr.insert(6);
		System.out.println(arr);
		System.out.println(arr.indexOf(2));
		arr.removeAt(4);
		System.out.println(arr);

		arr.removeAt(3);
		System.out.println(arr.indexOf(3));
		arr.removeAt(2);
		arr.removeAt(1);
		arr.removeAt(0);
		System.out.println(arr);
		System.out.println(arr.size());

		for (int i = 0; i < 21; i++) {
			arr.insert(i);
		}
		System.out.println(arr);
		System.out.println(arr.size());
		System.out.println(arr.indexOf(3));
	}
}
