package leetCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Task046Permutations_ {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11});
        System.out.println(permute.size());
//        AtomicInteger count = new AtomicInteger();
//        permute.forEach(lol -> System.out.println(count.getAndIncrement() + ": " + lol));
    }
}

class Task046Permutations {
    static private int counter = 0;
    static private List<Integer> integers = new ArrayList<>();

    private static void permute(int[] ints, int index) {
        if (index == ints.length) {
//            System.out.println(counter++ + ": " + Arrays.toString(ints));
            integers.add(counter++);
        } else {

            for (int i = index; i < ints.length; i++) {
                swap(ints, index, i);
                permute(ints, index + 1);
                swap(ints, i, index);
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        permute(ints, 0);
        System.out.println(integers.size());
    }

    private static void swap(int[] arr, int i, int j) {
        int buff = arr[i];
        arr[i] = arr[j];
        arr[j] = buff;
    }
}