public class subArraySumWithKsize {
    private static int helper(int[] arr, int k) {
        // Base condition handling
        if (arr == null || arr.length < k || k <= 0) {
            return 0;
        }

        int currentWindowSum = 0;
        // Compute sum of the first window
        for (int i = 0; i < k; i++) {
            currentWindowSum += arr[i];
        }

        int maxSum = currentWindowSum;

        // Slide the window across the rest of the array
        for (int i = k; i < arr.length; i++) {
            // Add next element, subtract leftmost element of previous window
            currentWindowSum += arr[i] - arr[i - k];
            // Track the maximum window sum found
            maxSum = Math.max(maxSum, currentWindowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {// main function
        int arr[] = {1, 5, 6, 8, 2, 3, 4, 7, 10, 15, 11, 17, 13};
        int k = 3;
        System.out.println("sum is " + helper(arr, k)); 
    }
}