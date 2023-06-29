package Easy;

import java.util.HashMap;
import java.util.Map;

public class MaxOccurringChar {
    public static void main(String[] args) {
        System.out.println(maxOccurringCharacter("testsample"));
        System.out.println(maxOccurringCharacter("sprouting"));
        System.out.println(maxOccurringCharacter("nosense"));
    }
 /**
  * Given a string str of lowercase alphabets find the maximum occurring character in the string str.
  * */
    static Character maxOccurringCharacter(String s) {
        Map<Long, Character> map = new HashMap<>();
        s.chars().distinct().forEach(
                c -> {
                    var key = s.chars().filter(ch -> ch == c).count();
                    if (!map.containsKey(key))
                        map.put(key, (char) c);
                }
        );
        var k = map.keySet().stream().max(Long::compare).get();
        return map.get(k);
    }
}
