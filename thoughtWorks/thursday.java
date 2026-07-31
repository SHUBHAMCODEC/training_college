import java.util.*;

public class thursday {

    private static void reverseArray(int[] arr){
        int low=0,high=arr.length-1;
        System.out.println("\n");
        System.out.print("before reverse: ");
        for(int i:arr){
            System.out.print(i+" ");
        }

        while(low<high){
            int temp=arr[low];
            arr[low]=arr[high];
            arr[high]=temp;

            low++;high--;
        }
        System.out.println("");
        System.out.print("After reverse: ");
        for(int i:arr){
            System.out.print(i+" ");
        }
    }

    private static void palindromeString(String s){
        int low=0,high=s.length()-1;
        s=s.toLowerCase();
        while(low<high){
            if(s.charAt(low)!=s.charAt(high)){
                System.out.println("Given String is not a valid palindrome...");
                return;
            }
            low++;high--;
        }
        System.out.println("Given String is a valid palindrome...");
    }

    private static void removeDuplicatesFromSortedArray(int arr[]){
        int slow=0,index=1;

        System.out.print("Array with duplicates : ");
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
        for(int fast=1;fast<arr.length;fast++){
            if(arr[slow]!=arr[fast]){
                arr[index++]=arr[fast];
                slow=fast;
            }
        }
        System.out.print("Array withOut duplicates : ");
        for(int i=0;i<index;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    
    private static void moveZeroestoEnd(int arr[]){
        int slow=0,fast=0;
        
        System.out.print("Array with 0's : ");
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();

        while(fast<arr.length){
            if(arr[fast]!=0){
                int temp=arr[slow];
                arr[slow]=arr[fast];
                arr[fast]=temp;
                slow++;fast++;
            }else{
                fast++;
            }
        }
        System.out.print("Array withOut 0's : ");
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    private static int[] TwoSum(int arr[],int target){
        int low=0,high=arr.length-1;
        while(low<high){
            if(arr[low]+arr[high]==target){
                return new int[]{low,high};
            }else if(arr[low]+arr[high]<target){
                low++;
            }else{
                high--;
            }
        }
        return new int[]{-1,-1};
    }

    public static void maxArea(int[] height) {
        int left=0, right=height.length-1;
        int area=0, max=0;
        while(left<right){
            int width=right-left;
            int heights=Math.min(height[left],height[right]);
            area=width*heights;
            max=Math.max(max,area);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        System.out.println("maximum amount of water a container can store: "+max); 
    }

    public static void sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                res[i] = nums[left] * nums[left];
                left++;
            } else {
                res[i] = nums[right] * nums[right];
                right--;
            }
        }

        System.out.print("square of sorted Array : ");
        for(int i:res){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    //--------------------Sliding Window -------------------------------------------------

    private static void maximumSubArraywithSizeK(int arr[],int k){
        if (arr.length < k) return;
        int windowSum=0;
        for(int i=0;i<k;i++){
            windowSum+=arr[i];
        }

        int maxSum=windowSum;
        for(int i=k;i<arr.length;i++){
            windowSum+=arr[i]-arr[i-k];
            maxSum=Math.max(maxSum, windowSum);
        }
        System.out.println("maximum SubArray with Size 'K' : "+ maxSum);
    }

    private static void First_Negative_Integer_in_Every_Window_of_Size_K(int[] arr,int k){
        ArrayList<Integer>ls=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<k;i++){
            if(arr[i]<0){
                q.add(i);
            }
        }

        if(!q.isEmpty()){
            ls.add(arr[q.peek()]);
        }else{
            ls.add(0);
        }

        for(int i=k;i<arr.length;i++){
            while(!q.isEmpty() && q.peek()<=i-k){
                q.remove();
            }
            if(arr[i]<0){
                q.add(i);
            }

            if(!q.isEmpty()){
                ls.add(arr[q.peek()]);
            }else{
                ls.add(0);
            }
        }
        System.out.println("First Negative Integer in Every Window of Size K: "+ls);
    }

    private static void Longest_Subarray_with_SumLessthanK(int[] arr,int k){
        int sum=0,maxLength=0,low=0;
        for(int high=0;high<arr.length;high++){
            sum+=arr[high];
            while(sum>=k && low<=high){
                sum-=arr[low];
                low++;
            }
            if(sum<k){
                maxLength=Math.max(maxLength, high-low+1);
            }
        }
        System.out.println("Length of Longest Subarray with Sum < " + k + ": " + maxLength);
    }

    private static void longestSubStringWithoutRepeatingCharacters(String s){
        HashSet<Character> stt=new HashSet<>();
        int low=0; int maxLength=0;
        for(int high=0;high<s.length();high++){
            while(stt.contains(s.charAt(high))){
                stt.remove(s.charAt(low));
                low++; // Fixed infinite loop here
            }

            stt.add(s.charAt(high));
            maxLength=Math.max(maxLength,high-low+1);
        }
        System.out.println("longest SubString Without Repeating Characters: "+ maxLength);
    }

    private static void Maximum_Number_of_Vowels_in_a_Substring_of_Length_K(String s,int k){
        
        int count=0;
        for(int i=0;i<k;i++){
            char c=s.charAt(i);
            if(c=='a'|| c=='e'||c=='i'|| c=='o'||c=='u'){
                count++;
            }
        }
        int maxCount=count;
        
        for(int i=k;i<s.length();i++){
            char c=s.charAt(i-k);
            if(c=='a'|| c=='e'||c=='i'|| c=='o'||c=='u'){
                count--;
            }
            char curr=s.charAt(i);
            if(curr=='a'|| curr=='e'||curr=='i'|| curr=='o'||curr=='u'){
                count++;
            }

            maxCount=Math.max(maxCount,count);
        }

        System.out.println("Maximum Number of Vowels in a Substring of Length ("+k+") : "+maxCount);
    }


    private static void Minimum_Size_Subarray_Sum(int arr[],int target){
        int sum=0,low=0;
        int miniSize=Integer.MAX_VALUE;
        for(int high=0;high<arr.length;high++){
            sum+=arr[high];
            while(sum>=target && low<=high){
                int size=high-low+1;
                sum-=arr[low++];
                miniSize=Math.min(size,miniSize);
            }
        }

        if(miniSize==Integer.MAX_VALUE){
            miniSize=-1;
        }
        System.err.println("Minimum Size Subarray Sum: "+miniSize);
    }

    private static int[] slidingWindowMaximum(int[] nums, int k) {
        // Edge case: if array is empty or k is 0
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        
        int n = nums.length;
        int[] result = new int[n - k + 1]; // Total windows = n - k + 1
        int ri = 0; // Index for the result array
        
        // Deque will store indices of elements
        Deque<Integer> q = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            // 1. Remove indices that are out of the current window boundary
            if (!q.isEmpty() && q.peekFirst() == i - k) {
                q.pollFirst();
            }
            
            // 2. Maintain monotonic decreasing order
            // Remove elements from the back that are smaller than the current element
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
                q.pollLast();
            }
            
            // Add current element's index to the back
            q.offerLast(i);
            
            // 3. The first window hits its full size at index k - 1
            // From here on, the front of the deque is the maximum for the current window
            if (i >= k - 1) {
                result[ri++] = nums[q.peekFirst()];
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8,15,18,20,25};
        reverseArray(arr); 

        System.out.println("\n");
        palindromeString("aman");
        palindromeString("aabaabaabaab");
        palindromeString("aaaabbbccdccbbbaaaa");
        palindromeString("Naman"); 
        
        System.out.println("\n");
        removeDuplicatesFromSortedArray(new int[]{1,2,2,3,4,4,4,5,6,7,8,9,9,10,10,11,12,15,15,15,25});

        System.out.println();
        moveZeroestoEnd(new int[]{0,1,2,0,0,3,0,4,0,0,5,6,0,7,0,0});
        moveZeroestoEnd(new int[]{1,0,2,3,0,4,5,0,6,0,7,0,8,9,10});

        System.out.println("\n");
        int sum[]=TwoSum(new int[]{1,2,3,4,5,7}, 11);
        
        System.out.print("Two Sum array : ");
        for(int i:sum){
            System.out.print(i+" ");
        }
        System.out.println("\n");

        maxArea(new int[]{1,8,6,2,5,4,8,3,7});

        System.out.println("\n");
        sortedSquares(new int[]{-7,-3,2,3,11});
        sortedSquares(new int[]{-4,-1,0,3,10});

        System.out.println("\n --------------------Sliding Window -------------------------------------------------");
        maximumSubArraywithSizeK(new int[]{1,0,2,3,0,4,5,0,1}, 2);
        maximumSubArraywithSizeK(new int[]{1,0,2,3,0,4,5,0,1}, 3);
        maximumSubArraywithSizeK(new int[]{1,0,2,3,0,4,5,0,1}, 4);

        System.out.println("\n");
        First_Negative_Integer_in_Every_Window_of_Size_K(new int[]{12, -1, -7, 8, -15, 30, 16, 28}, 3);

        System.out.println("\n");
        // Note: The array size (5) is less than K (7). Added boundary check inside the method to prevent out of bounds.
        maximumSubArraywithSizeK(new int[]{2, 1, 3, 4, 5}, 7); 
        
        System.out.println(); // Fixed syntax truncation here

        longestSubStringWithoutRepeatingCharacters(new String("abcabcbb"));

        System.out.println("\n");
        Maximum_Number_of_Vowels_in_a_Substring_of_Length_K(new String("abciiidef"), 3);

        System.out.println("\n");
        Minimum_Size_Subarray_Sum(new int[]{2,3,1,2,4,3},7);

        System.out.println("\n");
        slidingWindowMaximum(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);

    }
}
