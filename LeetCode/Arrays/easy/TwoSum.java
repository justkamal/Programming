package Arrays.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Problem link: https://leetcode.com/problems/two-sum/
 * Companies: adobe | airbnb | amazon | apple | bloomberg | dropbox | facebook | linkedin | microsoft | uber | yahoo | yelp
 */

public class TwoSum {

    //Runtime : 15ms
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();

        /**
         * Since we are finding 'pairs' each element in solution pair will be complimentary with  another
         * so we can link from either one. Hence we can prepare the hashmap along with finding the compliment
         * as it's okay to find later since both elements will be connected no matter the order
         * With this explanation, single iteration solution is implemented in the latter code
         * */
        prepareMap(indexMap, nums);

        return findComplement(indexMap, nums, target);
    }

    private int[] findComplement(HashMap<Integer, Integer> indexMap, int[] nums, int target) {
        int[] twoSumIndex = new int[2];

        for (int index = 0; index < nums.length; ++index) {
            Integer findIndex = indexMap.get(target - nums[index]);
            if (Objects.nonNull(findIndex) && findIndex != index) {
                twoSumIndex[0] = index;
                twoSumIndex[1] = indexMap.get(target - nums[index]);
                break;
            }
        }
        return twoSumIndex;
    }

    private void prepareMap(HashMap<Integer, Integer> complimentaryMap, int[] nums) {
        for (int index = 0; index < nums.length; ++index) {
            complimentaryMap.put(nums[index], index);
        }
    }

    public static void main(String[] args) {
        int nums[] = {2, 5, 2, 15};
        int target = 4;
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(nums, target)));
    }

    //Runtime: 8ms
    public int[] findTwoPairs(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            int complement = target - nums[index];
            if (indexMap.containsKey(complement)) {
                return new int[]{indexMap.get(complement), index};
            }
            indexMap.put(nums[index], index);
        }
        // In case there is no solution, we'll just return null
        return null;
    }
}
