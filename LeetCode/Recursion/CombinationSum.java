package Recursion;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/combination-sum/
 * Companies: snapchat | uber
 */

public class CombinationSum {
    public static void main(String[] args) {
        CombinationSum mainObj = new CombinationSum();
        System.out.println(Arrays.toString(mainObj.combinationSum(new int[]{2, 3, 6, 7}, 7).toArray()));
        System.out.println(Arrays.toString(mainObj.optimizedCombinationSum(new int[]{2, 3, 6, 7}, 7).toArray()));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resultSet = new ArrayList<>();
        HashSet<List<Integer>> uniqueResultSet = new HashSet<>();
        List<Integer> singleSet = new ArrayList<>();
        Arrays.sort(candidates);
        computeCombination(candidates, target, singleSet, uniqueResultSet);
        resultSet.addAll(uniqueResultSet);
        return resultSet;
    }

    private void computeCombination(int[] arr, int target, List<Integer> singleSet, HashSet<List<Integer>> resultSet) {
        if (target == 0) {
            List<Integer> copyList = new ArrayList<>();
            copyList.addAll(singleSet);
            Collections.sort(copyList);
            resultSet.add(copyList);
            return;
        }
        for (int i = 0; i < arr.length && arr[i] <= target; ++i) {
            singleSet.add(arr[i]);
            computeCombination(arr, target - arr[i], singleSet, resultSet);
            singleSet.remove(singleSet.size() - 1);
        }
    }

    public List<List<Integer>> optimizedCombinationSum(int[] candidates, int target) {
        List<List<Integer>> resultSet = new ArrayList<>();
        optimizedComputeCombination(0, candidates, target, new ArrayList<>(), resultSet);
        return resultSet;
    }

    public void optimizedComputeCombination(int index, int[] arr, int target, List<Integer> dataSet, List<List<Integer>> resultSet) {
        if (index == arr.length){
            if (target == 0){
                resultSet.add(new ArrayList<>(dataSet));
            }
            return;
        }
        if (arr[index] <= target) {
            dataSet.add(arr[index]);
            optimizedComputeCombination(index, arr, target - arr[index], dataSet, resultSet);
            dataSet.remove(dataSet.size() - 1);
        }
        optimizedComputeCombination(index + 1, arr, target, dataSet, resultSet);
    }
}