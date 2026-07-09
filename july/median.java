import java.util.*;

class median {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        
        // 1. Merge both arrays
        for(int i : nums1) list.add(i);
        for(int i : nums2) list.add(i);

        // 2. IMPORTANT: You must sort the list to find the median
        Collections.sort(list);

        int n = list.size();
        if (n % 2 != 0) {
            
            return list.get(n / 2);
        } else {
            // Even: Average of the two middle elements
            // Use 2.0 to ensure double division
            return (list.get(n / 2) + list.get(n / 2 - 1)) / 2.0;
        }
    }

    public static void main(String[] args){
        System.out.println(findMedianSortedArrays(new int[]{1,5,7,8,9},{78,45,12,56,55,89,80}));
    }
}
