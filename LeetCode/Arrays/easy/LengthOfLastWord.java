package Arrays.easy;

import java.util.Arrays;

/**
 * Problem link: https://leetcode.com/problems/length-of-last-word/
 * Companies:
 * */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        String words[] = s.split(" ");
        System.out.println(Arrays.toString(words));
        return words[words.length-1].length();
    }

    public static void main(String[] args) {
        LengthOfLastWord mainObj = new LengthOfLastWord();
        System.out.println(mainObj.lengthOfLastWord("   fly me   to   the moon     "));
    }
}
