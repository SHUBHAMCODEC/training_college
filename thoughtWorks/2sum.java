package thoughtWorks;
import java.util.*;
public class 2sum {

    private static void helper(int arr[],int target){
        HashMap<Integer,Integer> mpp=new HashMap<>();

        for(int i=0;i<arr.length;i++){
            int remain=target-arr[i];
            if(mpp.containsKey(remain)){
                System.out.println("indeces are"+ mpp.get(remain)+" and "+ i);
                return;
            }

            mpp.put(arr[i],i);
        }

        
    }
    public static void main(String[] args) {
       helper(new int[]{1,2,3,47,15,13,149,20}, 23);
    }
}
