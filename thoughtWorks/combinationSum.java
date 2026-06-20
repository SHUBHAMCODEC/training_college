package thoughtWorks;

import java.util.*;

public class combinationSum {
    
    private static void helper(int ind,int[] arr,int target,List<List<Integer>> ls,List<Integer> curr){// helper function
        if(ind==arr.length){
            if(target==0){
                ls.add(new ArrayList<>(curr));
            }
            return;
        }

        if(arr[ind]<=target){
            curr.add(arr[ind]);
            helper(ind+1, arr, target-arr[ind], ls, curr);
            curr.remove(curr.size()-1);
        }
        helper(ind+1, arr, target, ls, curr);
    }

    public static void main(String[] args) {// main function for running code
        int arr[]={1,2,3};
        int target=5;
        List<List<Integer>> ls=new ArrayList<>();
        helper(0, arr, target, ls,new ArrayList<>());

        System.out.println(ls);
    }
}