import java.util.Arrays;

public class CustomArray {
	private int pointer;
	private int[] arr;

	public CustomArray(int initialSize) {
		this.arr = new int[initialSize];
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

	@Override
	public String toString() {
		return Arrays.toString(Arrays.copyOfRange(arr, 0, pointer));
	}

	private void increaseSize() {
		int[] newArr = new int[arr.length * 2];
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];
		}

		this.arr = newArr;
	}
}
