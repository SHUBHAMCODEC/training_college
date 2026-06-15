package thoughtWorks;

// CRITICAL FIX: Added missing imports
import java.util.HashMap;
import java.util.Map;

public class findDuplicate {
    private static void helper(int arr[]) {
        int n = arr.length;
        
        // Approach 1 -> Brute Force
        boolean foundApproach1 = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                } else if (arr[i] == arr[j]) {
                    // CRITICAL FIX: Print arr[j] (value) instead of j (index)
                    System.out.println("Answer from approach 1: " + arr[j]);
                    foundApproach1 = true;
                    break; 
                }
            }
            // CRITICAL FIX: Removed the immediate 'break' that killed the outer loop
            if (foundApproach1) {
                break;
            }
        }

        // Approach 2 -> Mathematical Formula
        int ActualSum = (n * (n - 1) / 2);
        int dummySum = 0;
        for (int i : arr) {
            dummySum += i;
        }
        System.out.println("2nd Approach answer: " + (dummySum - ActualSum));

        // Approach 3 -> HashMap
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > 1) {
                System.out.println("3rd Approach answer: " + e.getKey());
                return; // Ends the helper method execution cleanly
            }
        }
    }

    // CRITICAL FIX: Changed 'voi' to 'void'
    public static void main(String[] args) { 
        // Case 1: Standard case
        System.out.println("--- Test Case 1: Standard ---");
        int[] arr1 = {1, 3, 4, 2, 2};
        helper(arr1);

        // Case 2: Duplicate is at the very beginning
        System.out.println("\n--- Test Case 2: Duplicate at Start ---");
        int[] arr2 = {1, 1, 2, 3, 4};
        helper(arr2);

        // Case 3: Duplicate is at the very end
        System.out.println("\n--- Test Case 3: Duplicate at End ---");
        int[] arr3 = {1, 2, 3, 4, 4};
        helper(arr3);

        // Case 4: Multiple copies of the SAME duplicate
        System.out.println("\n--- Test Case 4: Triple Duplicate ---");
        int[] arr4 = {1, 2, 2, 2, 4}; 
        helper(arr4);

       
    }
}
