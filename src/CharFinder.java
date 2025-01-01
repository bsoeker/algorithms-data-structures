import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {

    public char findFirstNonRepeatingChar(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (var entry : map.entrySet()) {
            if (entry.getValue() == 1)
                return entry.getKey();
        }

        return '\0';
    }

    public char findFirstRepeatedChar(String str) {
        Set<Character> set = new HashSet<>();
        for (char ch : str.toCharArray()) {
            if (set.contains(ch))
                return ch;

            set.add(ch);
        }

        return '\0';
    }
}
