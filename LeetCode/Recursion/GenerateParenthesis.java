package Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem link: https://leetcode.com/problems/generate-parentheses/
 * Companies: google | uber | zenefits
 */
public class GenerateParenthesis {

    private void generateCombination(List<String> result, StringBuilder str, int open, int close, int n) {
        if (str.length() == n*2) {
            result.add(str.toString());
            return;
        } else if (open < n) {
            str.append("(");
            generateCombination(result, str.append("("), open + 1, close, n);
            str.deleteCharAt(str.length() - 1);
        } if (close < open) {
            str.append(")");
            generateCombination(result, str.append(")"), open, close + 1, n);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateCombination(result, new StringBuilder(), 0, 0,  n);
        return result;
    }

    public static void main(String[] args) {
        GenerateParenthesis mainObj = new GenerateParenthesis();
        System.out.println(mainObj.generateParenthesis(3));
    }
}
