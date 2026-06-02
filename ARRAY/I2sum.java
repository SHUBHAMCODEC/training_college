import java.util.*;

public class I2sum {


    private static int[] helper(int nums[], int target){
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int remain=target-nums[i];

            if(map.containsKey(remain)){
                int data=map.get(remain);
                return new int[]{i,data};
            }
            map.put(nums[i],i);
        }

        return new int[]{};
    }

    private static int[] helper2(int arr[],int target){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]+arr[j]==target){
                    return new int[]{i,j};
                }
            }
        }


        return new int[]{-1,-1};
    }
    public static void main(String[] args){
        int[] arr=helper2(new int[]{1,2,3,7,8,6},10);
        System.out.println();
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
