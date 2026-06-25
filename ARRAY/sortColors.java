import java.util.HashMap;

public class Solution {
    public void sortColors(int[] nums) {
        // Initialize counts for 0, 1, and 2
        HashMap<Integer, Integer> count = new HashMap<>();
        count.put(0, 0);
        count.put(1, 0);
        count.put(2, 0);

        // Pass 1: Populate frequencies
        for (int num : nums) {
            // Using getOrDefault prevents crashes if a non-0/1/2 value exists
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // Pass 2: Overwrite the original array in sorted order
        int idx = 0;
        for (int color = 0; color < 3; color++) {
            int freq = count.get(color);
            for (int j = 0; j < freq; j++) {
                nums[idx] = color;
                idx++;
            }
        }        
    }
}
