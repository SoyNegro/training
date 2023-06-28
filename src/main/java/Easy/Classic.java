package Easy;

import java.util.ArrayList;
import java.util.List;

public class Classic {
    public static void main(String[] args) {
        System.out.println(isPalindrome("())("));
        System.out.println(isPalindrome("lolo"));

        System.out.println(isAnagram("cuba","bacu"));
        System.out.println(isAnagram("bacu","acu"));

        System.out.println(fibonacci(8));
    }
    /**
     * Classic easy problem
     * Given a String s return true if s is palindrome or false otherwise
     * */
    static boolean isPalindrome(String s){
        var reverse =  new StringBuilder(s).reverse().toString();
        return s.equals(reverse);
    }

    /**
     * Classic easy problem
     * Given two strings s1,s2 return true if s2 is an anagram of s1, or false otherwise
     * */
    static boolean isAnagram(String s1, String s2){
        if(s1.length()!=s2.length()) return false;
        return s1.chars().sum() == s1.chars().sum();
    }

    /**
     * Classic easy problem
     * Given a number n return a List containing the first n-numbers of the Fibonnaci Sequence
     * */
    static List<Integer> fibonacci(int n){
        var num1 = 0;
        var num2 = 1;
        var list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(num1);
            var num3 = num1 + num2;
            num1 = num2;
            num2 = num3;
        }
        return list;
    }
}
