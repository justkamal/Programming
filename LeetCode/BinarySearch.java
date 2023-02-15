import java.util.Arrays;

/**
 * @Problem : https://leetcode.com/problems/search-in-rotated-sorted-array/
 * @Companies: bloomberg | facebook | linkedin | microsoft | uber
 */
public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch mainObj = new BinarySearch();
        System.out.println(mainObj.search(new int[]{1, 6}, 6));
    }

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) return mid;

            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return nums[low] == target ? low : -1;
    }
}