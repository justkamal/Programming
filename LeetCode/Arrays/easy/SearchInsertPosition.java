package Arrays.easy;


/**
 * Problem link: https://leetcode.com/problems/search-insert-position/
 */
public class SearchInsertPosition {

    private static int searchInsertPos(int[] arr, int target) {
        int ans = arr.length;
        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] >= target) {
                end = mid - 1;
                ans = mid;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Index found: " + searchInsertPos(new int[]{2, 3, 4, 5}, 1));
    }
}
