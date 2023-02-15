package Arrays.medium;

import java.util.Arrays;

/**
 * @Problem: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * @Companies: linkedin
 */
public class FindFirstAndLastPos {
    public static void main(String[] args) {
        FindFirstAndLastPos mainObj = new FindFirstAndLastPos();
        System.out.println(Arrays.toString(mainObj.searchRange(new int[]{5,7,7,8,8,10}, 8)));
    }

    public int[] searchRange(int[] arr, int target) {
        int first = lowerBound(arr, target);
        if (first == arr.length || arr[first] != target) {
            return new int[]{-1, -1};
        }
        int last = lowerBound(arr, target + 1);

        return new int[]{first, last - 1};
    }

    public int lowerBound(int[] arr, int target){
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                //should not be mid-1 when arr[mid]==target.
                //could be mid even if arr[mid]>target because mid<high.
                high = mid;
            }
        }
        return low;
    }
}