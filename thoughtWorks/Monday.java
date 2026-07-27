package thoughtWorks;
import java.util.*;
public class Monday {

    private static int Largest_Element_in_an_Array(int arr[]){
        int max=Integer.MIN_VALUE;
        for(int i:arr){
            if (i>max){
                max=i;
            }
        }

        return max;
    }

    private static int Second_Largest_Element(int arr[]){
        int max=Integer.MIN_VALUE;
        int secMax=Integer.MIN_VALUE;
        if(arr.length==1){
            return arr[0];
        }
        for(int i:arr){
            if(i>max){
                secMax=max;
                max=i;
            }else if (i<max && i>secMax) {
                secMax=i;
            }
        }

        return secMax;
    }

    private static boolean  Check_if_Array_is_Sorted(int [] arr){
        boolean status=true;

        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                status=false;
                return status;
            }
        }

        return status;
    }

    private static int[] Reverse_an_Array(int [] arr){
        int low=0,high=arr.length-1;

        while(low<high){
            int temp=arr[low];
            arr[low]=arr[high];
            arr[high]=temp;

            low++;high--;
        }

        return arr;
    }

    private static int[] Left_Rotate_Array_by_One(int [] arr,int k){
        int n=arr.length;
        int actualRotation=k%n;

        while(actualRotation>0){
            int temp=arr[0];
            for(int i=1;i<n;i++){
                arr[i-1]=arr[i];
            }
        
            arr[n-1]=temp;
            actualRotation--;
        }

        return arr;
            
    }
    private static int[] Move_All_Zeroes_to_End(int [] arr){
        int index=0;

        for(int i:arr){
            if(i!=0){
                arr[index++]=i;
            }
        }
        for(int j=index;j<arr.length;j++){
            arr[j]=0;
        }

        return arr;
    }
    private static void Remove_Duplicates_from_Sorted_Array(int [] arr){
        int low=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i-1]==arr[i]){
                continue;
            }else{
                arr[low++]=arr[i];
            }
        }

        System.out.print("updated Array Elements are: ");
        for(int i=0;i<low;i++){
            System.out.print(arr[i]+" ");
        }

        System.out.println("\n");
    }

    private static ArrayList<Integer> Merge_Two_Sorted_Arrays(int ar1[],int ar2[]){
        int n=ar1.length;
        int m=ar2.length;

        ArrayList<Integer> result=new ArrayList<>();

        int i=0,j=0;
        while(i<n && j<m){
            if(ar1[i]<ar2[j]){
                result.add(ar1[i++]);
            }else{
                result.add(ar2[j++]);
            }
        }

        while(i<n){
        result.add(ar1[i++]);
        }
        while(j<m){
            result.add(ar2[j++]);
        }

        return result;
    }

    private static int[] Two_Sum(int arr[],int target){
        HashMap<Integer,Integer> mpp=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int remains=target-arr[i];
            if(mpp.containsKey(remains)){
                int index=mpp.get(remains);
                return new int[]{i,index};
            }

            mpp.put(arr[i],i);
        }

        for(Map.Entry<Integer,Integer> i: mpp.entrySet()){//extra for just sake of visualising the Map
            System.out.println("key: "+i.getKey()+" and value: "+ i.getValue());
        }

        return new int[]{-1,-1};
    }

    private static boolean Pair_with_Given_Sum_Sorted_Array(int arr[],int sum){
        int low=0, high=arr.length-1;
        while(low<high){
            if((arr[low]+arr[high])==sum){
                return true;
            }else if((arr[low]+arr[high])<sum){
                low++;
            }else{
                high--;
            }
        }
        return false;
    }

    private static int Running_Sum_of_Array(int arr[]){
        int sum=0;
        for(int i:arr){
            sum+=i;
        }

        return sum;
    }

    private static int Find_sum_Of_Range(int l, int r,int arr[]){
        int sum=0;
        if(l<0 || r>=arr.length || l>r){
            return 0;
        }
        for(int i=l;i<=r;i++){
            sum+=arr[i];
        }

        return sum;
    }
    private static int Maximum_Subarray_Sum(int arr[]){// kadane's algorithm
        int sum=0, max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            max=Math.max(sum,max);
            
            if(sum<0){
                sum=0;
            }
            
        }

        return max;
    }

    private static void Best_Time_to_Buy_and_Sell_Stock(int []arr){
        int profit=0;
        int buyDay=arr[0], sellDay=0;
        int buyKaDin=0; int BhechanKaDin=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]<buyDay){
                buyDay=arr[i];
                buyKaDin=i;
            }
            int max=arr[i]-buyDay;
            if(max>profit){
                profit=max;
                BhechanKaDin=i;
            }
        }

        System.out.println("profit achieved on stocks is : "+ profit + " for that  buy's day: "+buyKaDin +" ---------  and sell's day : "+ BhechanKaDin );
    }

    private static int[] Product_of_Array_Except_Self(int arr[]){
        
        int n = arr.length;
        int[] res = new int[n]; // Fixed: Don't modify original array mid-flight
        
        int prefix = 1;
        for (int i = 0; i < n; i++) {
            res[i] = prefix;
            prefix *= arr[i];
        }
        
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= suffix;
            suffix *= arr[i];
        }

        return res;
    }

    private static int Maximum_Sum_of_K_Consecutive_Elements(int [] arr,int k){// sliding window
        if (arr.length < k || k <= 0) return 0;
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        
        int max = windowSum;
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k]; // Sliding Window optimization
            max = Math.max(max, windowSum);
        }
        return max;
    }

    private static int Longest_Subarray_with_Sum(int[] arr,int s){
        int low = 0, sum = 0, maxLen = 0;
        for (int high = 0; high < arr.length; high++) {
            sum += arr[high];
            while (sum > s && low <= high) {
                sum -= arr[low++];
            }
            if (sum == s) {
                maxLen = Math.max(maxLen, high - low + 1);
            }
        }
        return maxLen;
    }

    private static int Longest_Substring_Without_Repeating_Characters(String s){
        HashSet<Character> set=new HashSet<>();
        int low=0;int max=0;
        for(int high=0;high<s.length();high++){
            char c=s.charAt(high);
            while(set.contains(c)){
                set.remove(s.charAt(low++));
            }
            set.add(c);
            max=Math.max(max,high-low+1);
            
        }

        return max;
    }

    private static void Majority_Element(int arr[]){
        int n=arr.length/2;
        HashMap<Integer,Integer> mpp=new HashMap<>();
        for(int i:arr){
            mpp.put(i, mpp.getOrDefault(i,0)+1);
        }

        for(Map.Entry<Integer,Integer> i:mpp.entrySet()){
            if(i.getValue()>n){
                System.out.println(i.getKey());
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("=== STARTING COMPREHENSIVE SUITE TESTING ===\n");

        // 1. Largest Element
        int[] t1 = {5, 9, -2, 11, 4};
        System.out.println("Largest Element", Largest_Element_in_an_Array(t1) == 11);

        // 2. Second Largest with duplicate max values
        int[] t2 = {7, 7, 2, 5, 6};
        System.out.println("Second Largest Element", Second_Largest_Element(t2) == 6);

        // 3. Check Sorted
        int[] t3_true = {1, 3, 5, 8};
        int[] t3_false = {1, 5, 3, 8};
        System.out.println("Check Sorted (True Scenario)", Check_if_Array_is_Sorted(t3_true));
        System.out.println("Check Sorted (False Scenario)", !Check_if_Array_is_Sorted(t3_false));

        // 4. Reverse Array
        int[] t4 = {1, 2, 3, 4};
        int[] t4_rev = Reverse_an_Array(t4);
        System.out.println("Reverse Array", t4_rev[0] == 4 && t4_rev[3] == 1);

        // 5. Left Rotate by K steps
        int[] t5 = {1, 2, 3, 4, 5};
        int[] t5_rot = Left_Rotate_Array_by_K(t5, 2);
        System.out.println("Left Rotate by K", t5_rot[0] == 3 && t5_rot[4] == 2);

        // 6. Move Zeroes
        int[] t6 = {0, -1, 0, 3, 12};
        int[] t6_res = Move_All_Zeroes_to_End(t6);
        System.out.println("Move Zeroes to End", t6_res[0] == -1 && t6_res[3] == 0 && t6_res[4] == 0);

        // 7. Remove Duplicates
        int[] t7 = {1, 1, 2, 2, 3};
        System.out.println("Remove Duplicates Len", Remove_Duplicates_from_Sorted_Array(t7) == 3);

        // 8. Merge Sorted Arrays
        int[] t8_a = {1, 3, 5};
        int[] t8_b = {2, 4, 6};
        ArrayList<Integer> merged = Merge_Two_Sorted_Arrays(t8_a, t8_b);
        System.out.println("Merge Two Sorted Arrays", merged.size() == 6 && merged.get(1) == 2);

        // 9. Two Sum
        int[] t9 = {2, 7, 11, 15};
        int[] t9_ans = Two_Sum(t9, 9);
        System.out.println("Two Sum Indices Lookup", (t9_ans[0] == 1 && t9_ans[1] == 0) || (t9_ans[0] == 0 && t9_ans[1] == 1));

        // 10. Pair with Sum Sorted
        int[] t10 = {1, 2, 4, 6, 9};
        System.out.println("Pair with Given Sum", Pair_with_Given_Sum_Sorted_Array(t10, 10));

        // 11. Running Sum
        int[] t11 = {1, 2, 3, 4};
        System.out.println("Running Sum Evaluation", Running_Sum_of_Array(t11) == 10);
    }
}
