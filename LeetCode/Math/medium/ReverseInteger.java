package Math.medium;

/**
 * Problem link: https://leetcode.com/problems/reverse-integer/
 * Companies: apple | bloomberg
 */

public class ReverseInteger {

    public int reverse(int x) {
        if (x == Integer.MIN_VALUE)
            return 0;
        boolean isNegative = x < 0 ? true : false;
        if (isNegative)
            x *= -1;
        StringBuilder numString = new StringBuilder(Integer.toString(x));
        numString.reverse();
        long newX = Long.parseLong(numString.toString());
        if (isNegative)
            newX *= -1;
        if (newX > Integer.MAX_VALUE || newX < Integer.MIN_VALUE)
            return 0;
        else
            return (int) newX;
    }

    public static void main(String[] args) {
        ReverseInteger mainObj = new ReverseInteger();
        System.out.println(mainObj.reverse(-2147483648));
    }
}
