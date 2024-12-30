import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        String str = "New York";
        System.out.println(reverse(str));
    }

    public static String reverse(String str) {
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
