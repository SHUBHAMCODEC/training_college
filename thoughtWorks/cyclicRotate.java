package thoughtWorks;

public class cyclicRotate {

    private static void helper(int arr[], int rotation) {
        System.out.println("Before rotation (K = " + rotation + "): ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        int n = arr.length;
        if (n == 0) return;

        // Fix: Normalize rotation using modulo
        int k = rotation % n; 
        
        // Handle negative rotations if passed by mistake
        if (k < 0) {
            k = k + n; 
        }

        // Fix: In-place optimal rotation using 3 reversals
        reverse(arr, 0, n - 1); // Step 1: Reverse whole array
        reverse(arr, 0, k - 1); // Step 2: Reverse first K elements
        reverse(arr, k, n - 1); // Step 3: Reverse remaining elements

        System.out.println("After rotation: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("\n------------------------------------");
    }

    // Helper method to reverse a specific subsection of the array
    private static void reverse(int arr[], int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        helper(new int[]{1, 2, 3, 4, 5, 6}, 1);
        helper(new int[]{1, 2, 3, 4, 5, 6}, 25);
        helper(new int[]{1, 2, 3, 4, 5, 6}, 15);
        helper(new int[]{1, 2, 3, 4, 5, 6}, 100);
        helper(new int[]{1, 2, 3, 4, 5, 6}, 10000);
        helper(new int[]{1, 2, 3, 4, 5, 6}, 150487);
    }
}
