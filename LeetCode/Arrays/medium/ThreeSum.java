package Arrays.medium;

import java.util.*;

/**
 * Problem link: https://leetcode.com/problems/3sum/
 */
public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum mainObj = new ThreeSum();
        int[] nums = {34, 55, 79, 28, 46, 33, 2, 48, 31, -3, 84, 71, 52, -3, 93, 15, 21, -43, 57, -6, 86, 56, 94, 74, 83, -14, 28, -66, 46, -49, 62, -11, 43, 65, 77, 12, 47, 61, 26, 1, 13, 29, 55, -82, 76, 26, 15, -29, 36, -29, 10, -70, 69, 17, 49};
        /*Set<List<Integer>> uniqueSet = new TreeSet<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> l1, List<Integer> l2) {
                return l1.containsAll(l2) ? 0 : 1;
            }
        });
        uniqueSet.add(Arrays.asList(-29,-14,23));
        uniqueSet.add(Arrays.asList(23,-14,-29));
        System.out.println(uniqueSet);*/
        System.out.println(mainObj.findTriplet(nums));
    }

    public List<List<Integer>> findTriplet(int nums[]) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> uniqueSet = new TreeSet<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> l1, List<Integer> l2) {
                return l1.containsAll(l2) ? 0 : 1;
            }
        });
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; ++i) {
            int b = i + 1;
            int c = nums.length - 1;
            while (b < c) {
                int currSum = nums[i] + nums[b] + nums[c];
                if (currSum < 0) {
                    ++b;
                } else if (currSum > 0) {
                    --c;
                } else if (currSum == 0) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[b]);
                    triplet.add(nums[c]);
                    if (!uniqueSet.contains(triplet)) {
                        uniqueSet.add(triplet);
                        result.add(triplet);
                    }
                    ++b;
                    --c;
                }
            }
        }
        return result;
    }
}
