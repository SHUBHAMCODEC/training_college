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
            }else{
                continue;
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
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8,15,18,20,25};
        //reverse Array
        reverseArray(arr); 

        System.out.println("\n");
        // palindrome
        palindromeString(new String("aman"));
        palindromeString(new String("aabaabaabaab"));
        palindromeString(new String ("aaaabbbccdccbbbaaaa"));
        palindromeString(new String("Naman")); 
        
        System.out.println("\n");

        //remove Duplicates from sorted Array

        removeDuplicatesFromSortedArray(new int[]{1,2,2,3,4,4,4,5,6,7,8,9,9,10,10,11,12,15,15,15,25});

        System.out.println();

        // Move All zeroes to End

        moveZeroestoEnd(new int[]{0,1,2,0,0,3,0,4,0,0,5,6,0,7,0,0});
        moveZeroestoEnd(new int[]{1,0,2,3,0,4,5,0,6,0,7,0,8,9,10});

        System.out.println("\n");

        //Two Sum II
        int sum[]=TwoSum(new int[]{1,2,3,4,5,7}, 11);
        
        System.out.print("Two Sum array : ");
        for(int i:sum){
            System.out.print(i+" ");
        }
        System.out.println("\n");

        // maximum water an container have

        maxArea(new int[]{1,8,6,2,5,4,8,3,7});

        System.out.println("\n");

        // square of sorted Array
        sortedSquares(new int[]{-7,-3,2,3,11});
        sortedSquares(new int[]{-4,-1,0,3,10});
    }
}

