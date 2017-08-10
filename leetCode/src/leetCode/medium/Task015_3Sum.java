package leetCode.medium;

/*Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]*/

import java.util.*;

public class Task015_3Sum {


    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};

        List<List<Integer>> lists = threeSum(nums);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        return null;
    }

    public static List<List<Integer>> threeSumNaive(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Set<List<Integer>> uniqueLists = new HashSet<>();

        Map<Integer, Integer> integers = new HashMap<>();

        int initialI = 0;
        int initialJ = 0;

        for (int num : nums) {
            if (integers.get(num) != null) {
                int aNum = integers.get(num) + 1;
                integers.put(num, aNum);
            } else {
                integers.put(num, 1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }

                int sumOfTwo = nums[i] + nums[j];
                ArrayList<Integer> temp = new ArrayList<>(3);

                temp.add(nums[i]);
                temp.add(nums[j]);
                temp.add(-1 * sumOfTwo);

                temp.sort(Comparator.naturalOrder());

                if (uniqueLists.contains(temp)) {
                    continue;
                }


                initialI = integers.get(nums[i]);
                initialJ = integers.get(nums[j]);

                if (sumOfTwo + nums[i] == 0 || sumOfTwo + nums[j] == 0) {

                    Integer integer = integers.remove(nums[i]);

                    if (integer - 1 > 0) {
                        integers.put(nums[i], integer - 1);
                    }
                    integer = integers.remove(nums[j]);
                    if (integer - 1 > 0) {
                        integers.put(nums[j], integer - 1);
                    }
                }
                if (integers.get(-1 * sumOfTwo) != null) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(-1 * sumOfTwo);
                    triplet.sort(Comparator.naturalOrder());

                    if (!uniqueLists.contains(triplet)) {
                        uniqueLists.add(triplet);
                        result.add(triplet);
                    }
                }

                integers.put(nums[i], initialI);
                integers.put(nums[j], initialJ);
            }
        }
        return result;
    }
}
