package Medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        System.out.println(generateParentheses(3));
    }

    // Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
    static List<String> generateParentheses(int n){
        var combinations = new ArrayList<String>();
        var open_so_far = 0;
        var closed_so_far = 0;
        generateCombinations(combinations,"",open_so_far,closed_so_far,n);
        return combinations;
    }

    static void generateCombinations(ArrayList<String> combinations, String current, int openSoFar, int closedSoFar, int n) {
        if (n*2==current.length()){
            combinations.add(current);
            return;
        }
        if (openSoFar<n) generateCombinations(combinations, current+"(", openSoFar+1, closedSoFar, n);
        if (closedSoFar<openSoFar) generateCombinations(combinations, current+")", openSoFar, closedSoFar+1, n);
    }
}
