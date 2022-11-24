package String.medium;

/**
 * Problem link: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
 * Companies: apple | facebook | microsoft | pocketgems
 */
public class FirstIndexOfFirstOccurrenceString {

    public int strStr(String haystack, String needle) {
        if (haystack.length() >= needle.length()) {
            int nIndex = 0, index = 0;
            char[] haystackArr = haystack.toCharArray();
            char[] needleArr = needle.toCharArray();
            while (index < haystack.length()) {
                nIndex = 0;
                while (nIndex < needleArr.length && (index + nIndex) < haystack.length()
                        && haystackArr[index + nIndex] == needleArr[nIndex]) {
                    ++nIndex;
                }
                if (nIndex == needleArr.length) {
                    return index;
                }
                ++index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstIndexOfFirstOccurrenceString mainObj = new FirstIndexOfFirstOccurrenceString();
        System.out.println(mainObj.strStr("mississippi", "issip"));
    }
}
