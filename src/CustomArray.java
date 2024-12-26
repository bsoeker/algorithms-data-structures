import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CustomArray {
	private int pointer;
	private int[] arr;

	public CustomArray(int initialSize) {
		this.arr = new int[initialSize];
	}

	private void increaseSize() {
		int[] newArr = new int[arr.length * 2];
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];
		}

		this.arr = newArr;
	}

	public void insert(int element) {
		if (pointer == arr.length)
			increaseSize();

		arr[pointer] = element;
		pointer++;
		return;
	}

	public int size() {
		return pointer;
	}

	public int indexOf(int element) {
		for (int i = 0; i < pointer; i++) {
			if (arr[i] == element)
				return i;
		}

		return -1;
	}

	public int removeAt(int index) {
		if (index >= pointer || index < 0)
			throw new ArrayIndexOutOfBoundsException();

		int popped = arr[index];
		if (index == pointer - 1) {
			pointer--;
			return popped;
		}

		for (int i = index; i < pointer - 1; i++) {
			arr[i] = arr[i + 1];
		}
		pointer--;
		return popped;
	}

	public int[] intersection(int[] otherArray) {
		// Using a set makes the implementation more concise although the runtimes are
		// both linear

		if (pointer == 0 || otherArray.length == 0)
			throw new IllegalStateException("One of the arrays is empty!");

		Map<Integer, Integer> integerCountTable = new HashMap<>();
		int[] intersection = new int[Math.min(pointer, otherArray.length)];

		for (int i = 0; i < pointer; i++) {
			integerCountTable.put(arr[i], integerCountTable.getOrDefault(arr[i], 0) + 1);
		}

		for (int i = 0; i < otherArray.length; i++) {
			integerCountTable.put(otherArray[i], integerCountTable.getOrDefault(otherArray[i], 0) + 1);
		}

		int i = 0;
		for (var entry : integerCountTable.entrySet()) {
			if (entry.getValue() > 1) {
				intersection[i] = entry.getKey();
				i++;
			}
		}

		return intersection;
	}

	public int maxValue() {
		if (pointer == 0)
			throw new IllegalStateException("The array is currently empty!");

		int max = arr[0];
		for (int i = 0; i < pointer; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		return max;
	}

	public void reverse() {
		if (pointer == 0)
			return;

		int[] temp = new int[pointer];
		for (int i = pointer - 1; i >= 0; i--) {
			temp[temp.length - i - 1] = arr[i];
		}

		// System.out.println(Arrays.toString(temp));
		for (int i = 0; i < pointer; i++) {
			arr[i] = temp[i];
		}
	}

	@Override
	public String toString() {
		return Arrays.toString(Arrays.copyOfRange(arr, 0, pointer));
	}
}
