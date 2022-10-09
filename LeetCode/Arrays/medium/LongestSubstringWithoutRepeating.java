package Arrays.medium;

import java.util.HashMap;

/**
 * Problem: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * Companies: adobe | amazon | bloomberg | yelp
 */
public class LongestSubstringWithoutRepeating {

    public int longestSubstring(String s) {
        char[] charStr = s.toCharArray();
        HashMap<Character, Integer> uniqueCharMap = new HashMap<>();
        int maxLen = uniqueCharMap.size();
        int currLen = 0;
        for (int i = 0, j = 0; j < charStr.length; ++j) {
            if (uniqueCharMap.containsKey(charStr[j])) {
                maxLen = Math.max(maxLen, currLen);
                int slide = uniqueCharMap.get(charStr[j]) + 1;
                while (i < slide){
                    uniqueCharMap.remove(charStr[i]);
                    ++i;
                    --currLen;
                }
            }
            uniqueCharMap.put(charStr[j], j);
            ++currLen;
        }

        return Math.max(maxLen, currLen);
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeating mainObj = new LongestSubstringWithoutRepeating();
        System.out.println(mainObj.longestSubstring("abba"));
    }
}