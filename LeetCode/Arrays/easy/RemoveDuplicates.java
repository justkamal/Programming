package Arrays.easy;

import java.util.Arrays;

/**
 * Problem link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * Companies: bloomberg | facebook | microsoft
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int ptr1, ptr2 = 0;
        for (ptr1 = 1, ptr2 = nums.length - 1; ptr1 < ptr2; ) {
            if (nums[ptr1] == nums[ptr1 - 1]) {
                swap(nums, ptr1, ptr2); //this will trouble you in last swap
                --ptr2;
            } else {
                ++ptr1;
            }
        }
        return nums[ptr1] == nums[ptr2] ? ptr1 : ptr1 + 1;
    }

    private void swap(int arr[], int x, int y) {
        arr[x] = arr[x] + arr[y];
        arr[y] = arr[x] - arr[y];
        arr[x] = arr[x] - arr[y];
    }

    //----------------------------------------------------------Solution------------------------------------------------
    public int solution(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {   //brings in the next distinct element
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int arr[] = new int[]{1, 1, 1};
        System.out.println(removeDuplicates.removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));

        arr = new int[]{1, 1, 1, 2, 2, 3, 3, 4 , 4};
        System.out.println(removeDuplicates.solution(arr));
        System.out.println(Arrays.toString(arr));

        arr = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates.removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));
    }
}

/**
 * 0 0 1 1 1 2 2 3 3 4
 * 0 4 1 1| 1 2 2 3 |3 0
 * 0 4 1 3 1 |2 |2 1 0
 */