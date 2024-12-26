import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		CustomArray arr = new CustomArray(5);
		try {
			System.out.println(arr.maxValue());
		} catch (Exception e) {
			System.out.println("Oops! Deliberate error for probing");
		}
		arr.insert(10);
		arr.insert(20);
		arr.insert(30);
		arr.insert(40);
		arr.insert(50);
		arr.insert(50);
		arr.insert(50);
		arr.insert(50);
		arr.insert(50);
		arr.insert(50);
		arr.insert(50);
		arr.insert(50);
		arr.insert(50);
		arr.insert(50);
		arr.insert(50);
		arr.removeAt(4);
		arr.removeAt(0);

		// System.out.println(arr.indexOf(20));
		// System.out.println(arr);
		// System.out.println(arr.maxValue());
		//
		// int[] otherArr = new int[10];
		// for (int i = 0; i < otherArr.length; i++) {
		// otherArr[i] = i * 10;
		// }
		//
		// System.out.println(Arrays.toString(arr.intersection(otherArr)));
		arr.reverse();
		System.out.println(arr);
	}
}
