import java.util.ArrayList;

public class printFirstSubSequenceTargetK { 
    // Change return type to boolean to stop recursion after finding the first match
    private static boolean helper(int index, int[] arr, int sum, ArrayList<Integer> ls, int n, int k) { 
        // Base case: reached the end of the array
        if (index == n) { 
            if (sum == k) { 
                System.out.println(ls); 
                return true; // Found the first subsequence, return true
            } 
            return false; // Did not match the target sum
        } 
        
        // 1. Take the current element
        ls.add(arr[index]);
        sum += arr[index];
        if (helper(index + 1, arr, sum, ls, n, k)) {// function
            return true; // Avoid further recursion if subset is found
        }
        
        // 2. Do not take the current element (Backtrack)
        sum -= arr[index];
        ls.remove(ls.size() - 1);
        if (helper(index + 1, arr, sum, ls, n, k)) {
            return true; // Avoid further recursion if subset is found
        }
        
        return false; // No valid subsequence found in this path
    } 

    public static void main(String[] args) { 
        int arr[] = {1, 2, 1}; 
        int k = 2; 
        int n = arr.length;
        ArrayList<Integer> ls = new ArrayList<>();
        
        // Call helper with initialized arguments
        helper(0, arr, 0, ls, n, k); 
    } 
}
