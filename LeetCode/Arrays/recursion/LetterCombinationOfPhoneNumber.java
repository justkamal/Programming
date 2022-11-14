package Arrays.recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhoneNumber {

    char[][] map = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
            {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    public static void main(String[] args) {
        LetterCombinationOfPhoneNumber mainObj = new LetterCombinationOfPhoneNumber();
        String digits = "";
        System.out.println(mainObj.letterCombinations(digits));
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() != 0) {
            computeCombo(result, digits, 0, "");
        }
        return result;
    }

    private void computeCombo(List<String> result, String digits, int index, String str) {
        if (index == digits.length()) {
            result.add(str);
            return;
        }
        int num = Integer.parseInt(digits.substring(index++, index));
        for (char c : map[num]) {
            computeCombo(result, digits, index, str + c);
        }
    }
}
