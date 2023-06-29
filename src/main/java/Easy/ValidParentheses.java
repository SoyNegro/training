package Easy;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        // All other characters are ignored altogether
        System.out.println(isValid("[()]{a}[]"));
        System.out.println(isValid("[)a(]{b}[c]"));
    }

    /**
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     *
     * An input string is valid if:
     *
     *     Open brackets must be closed by the same type of brackets.
     *     Open brackets must be closed in the correct order.
     *     Every close bracket has a corresponding open bracket of the same type.
     * */
    static boolean isValid(String s){
        var charStack =  new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            var charAt = s.charAt(i);
            switch (charAt){
                case '(','[','{' -> charStack.push(charAt);
                case  ')',']','}'-> {
                    if (charStack.isEmpty()) return false;
                    var topChar = charStack.pop();
                    if (topChar=='('&&charAt!=')') return false;
                    if (topChar=='['&&charAt!=']') return false;
                    if (topChar=='{'&&charAt!='}') return false;
                }
            }
        }
        return charStack.isEmpty();
    }
}
