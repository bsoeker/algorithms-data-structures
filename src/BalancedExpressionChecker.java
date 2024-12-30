import java.util.Map;
import java.util.Stack;

public class BalancedExpressionChecker {
    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> pairs = Map.of(
                '(', ')',
                '[', ']',
                '{', '}',
                '<', '>');

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (pairs.containsKey(ch))
                stack.push(ch);
            if (pairs.containsValue(ch)) {
                if (stack.isEmpty() || pairs.get(stack.peek()) != ch)
                    return false;

                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
