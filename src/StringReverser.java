import java.util.Stack;

public class StringReverser {
    public static String reverse(String str) {
        if (str == null)
            throw new IllegalArgumentException();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        StringBuffer resultBuffer = new StringBuffer();

        while (!stack.isEmpty()) {
            resultBuffer.append(stack.pop());
        }

        return resultBuffer.toString();
    }
}
