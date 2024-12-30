import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Stack<Integer> numbers = new Stack<>();
        System.out.println(numbers);

        for (int i = 0; i < 20; i++) {
            numbers.push(i);
        }

        System.out.println(numbers);

        Stack<Integer> reversed = new Stack<>();
        while (!numbers.isEmpty()) {
            reversed.push(numbers.pop());
        }
        System.out.println(reversed);
        System.out.println(numbers);
        System.out.println(reversed.peek());
    }

}
