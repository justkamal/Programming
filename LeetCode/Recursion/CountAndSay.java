package Recursion;

/**
 * Problem link: https://leetcode.com/problems/count-and-say/
 * Companies: facebook
 * */
public class CountAndSay {

    public static void main(String[] args) {
        CountAndSay mainObj = new CountAndSay();
        System.out.println(mainObj.countAndSay(4));
    }

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        char[] sayCount = countAndSay(n-1).toCharArray();
        StringBuilder newSayCount = new StringBuilder();
        int i = 0;
        while (i < sayCount.length) {
            int count = 0;
            char ch = sayCount[i];
            while (i < sayCount.length && ch == sayCount[i]){
                ++count;
                ++i;
            }
            newSayCount.append(count);
            newSayCount.append(ch);
        }
        return newSayCount.toString();
    }
}
