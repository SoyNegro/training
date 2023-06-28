package Easy;

public class Classic {
    public static void main(String[] args) {
        System.out.println(isPalindrome("())("));
        System.out.println(isPalindrome("lolo"));
    }
    /**
     * Classic easy problem
     * Given a String s return <code>true</code> if s is palindrome or <code>false</code> otherwise
     * */
    static boolean isPalindrome(String s){
        var reverse =  new StringBuilder(s).reverse().toString();
        return s.equals(reverse);
    }
}
