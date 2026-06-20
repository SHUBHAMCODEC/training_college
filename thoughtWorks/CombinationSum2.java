package thoughtWorks;

import java.util.*;

public class CombinationSum2 {

    private static void helper(int ind, int[] arr, int target,List<List<Integer>> ans,List<Integer> curr) {

        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = ind; i < arr.length; i++) {

            // Skip duplicates
            if (i > ind && arr[i] == arr[i - 1]) {
                continue;
            }

            // Since array is sorted
            if (arr[i] > target) {
                break;
            }

            curr.add(arr[i]);

            // i + 1 because each element can be used only once
            helper(i + 1, arr, target - arr[i], ans, curr);

            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        Arrays.sort(arr);

        List<List<Integer>> ans = new ArrayList<>();

        helper(0, arr, target, ans, new ArrayList<>());

        System.out.println(ans);
    }
}