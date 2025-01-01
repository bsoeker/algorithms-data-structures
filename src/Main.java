import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        CharFinder finder = new CharFinder();
        var result = finder.findFirstRepeatedChar("ndndfjgn");

        System.out.println(result);
    }
}
