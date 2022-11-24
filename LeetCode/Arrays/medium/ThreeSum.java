package Arrays.medium;

import java.util.*;

/**
 * Problem link: https://leetcode.com/problems/3sum/
 * Companies: adobe | amazon | bloomberg | facebook | microsoft
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

    class Triplet {
        private int x;
        private int y;
        private int z;

        public Triplet(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Triplet triplet = (Triplet) obj;
            return (this.x == triplet.x && this.y == triplet.y && this.z == triplet.z);
        }
    }

    public List<List<Integer>> findTriplet(int nums[]) {
        Set<List<Integer>> uniqueSet = new HashSet<>();
        //Approach: Sorting numbers and then fixing each number linearly as first and doing two-pointer search
        // on the right partition of it, finding optimal pairs for 'first' number
        Arrays.sort(nums);
        for (int first = 0; first < nums.length - 2; ++first) {
            int left = first + 1;
            int right = nums.length - 1;
            while (left < right) {
                int currSum = nums[first] + nums[left] + nums[right];
                if (currSum < 0) {
                    ++left;
                } else if (currSum > 0) {
                    --right;
                } else if (currSum == 0) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[first]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    if (!uniqueSet.contains(triplet)) {
                        uniqueSet.add(triplet);
                    }
                    ++left;
                    --right;
                }
            }
        }
        return uniqueSet.stream().toList();
    }
}
