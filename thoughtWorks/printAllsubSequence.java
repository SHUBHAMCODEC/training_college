package thoughtWorks;

import java.util.ArrayList;
import java.util.List;

public class printAllsubSequence {

    private static void helperRecur(int arr[],int i,List<List<Integer>> ls,List<Integer> ds){
        if(i==arr.length){
            ls.add(new ArrayList<>(ds));
            return;
        }

        //pick
        ds.add(arr[i]);
        helperRecur(arr, i+1, ls, ds);
        ds.remove(ds.size()-1);

        //non - pick
        helperRecur(arr, i+1, ls, ds);

        
    }
    private static void helperBit(int arr[]){
        int n=1<<arr.length;

        List<List<Integer>> mainList=new ArrayList<>();

        for(int i=0;i<n;i++){
            List<Integer> subList=new ArrayList<>();
            for(int j=0;j<arr.length;j++){
                if((i & (1<<j))!=0){
                    subList.add(arr[j]);
                }
            }
            mainList.add(subList);
        }


        System.out.println("All subSequence from recursion: ");
        System.out.println(mainList);
    }
    public static void main(String[] args) {
         int[] arr = {1, 2, 3};

        // Test Recursive Approach
        List<List<Integer>> recursiveResult = new ArrayList<>();
        helperRecur(arr, 0, recursiveResult, new ArrayList<>());
        System.out.println("All subSequences from Recursion: ");
        System.out.println(recursiveResult);

        System.out.println();

        // Test Bit Manipulation Approach
        helperBit(arr);
    }
}