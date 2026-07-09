import java.util.*;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        
        // 1. Merge both arrays
        for(int i : nums1) list.add(i);
        for(int i : nums2) list.add(i);

        // 2. IMPORTANT: You must sort the list to find the median
        Collections.sort(list);

        int n = list.size();
        if (n % 2 != 0) {
            // Odd: Return the middle element
            return list.get(n / 2);
        } else {
            // Even: Average of the two middle elements
            // Use 2.0 to ensure double division
            return (list.get(n / 2) + list.get(n / 2 - 1)) / 2.0;
        }
    }
}
