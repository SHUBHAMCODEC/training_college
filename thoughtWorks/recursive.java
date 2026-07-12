package thoughtWorks;
import java.util.*;
public class recursive {


    private static List<List<Integer>> helperBit(int arr[]){
        int num=arr.length;
        int n=1<<num;
        List<List<Integer>> mainList=new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> subList=new ArrayList<>();
            for(int j=0;j<num;j++){
                if(((i&(1<<j))!=0)){
                    subList.add(arr[j]);
                }
            }
            mainList.add(subList);
        }

        return mainList;
    }


    private static void helperByrecursion(int index,int arr[],List<List<Integer>> main,List<Integer> sub){
        if(index==arr.length){
            main.add(new ArrayList<>(sub));
            return;
        }

        //pick and not Pick


        //pick
        sub.add(arr[index]);
        helperByrecursion(index+1, arr, main, sub);

        //not pick
        sub.remove(sub.size()-1);

        helperByrecursion(index+1, arr, main, sub);
    }
    public static void main(String[] args) {

        int[] input = {1, 2, 3};

        // 1. Testing Bit Manipulation Approach
        List<List<Integer>> subsets = helperBit(input);
        
        System.out.println("All generated subsets via Bit Manipulation:");
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }

        System.out.println("\n--------------------------------------------------\n");
        
        // 2. Testing Recursive Approach
        List<List<Integer>> subsetsRecursive = new ArrayList<>();
        helperByrecursion(0, input, subsetsRecursive, new ArrayList<>());
        
        System.out.println("All generated subsets via Recursion (Pick / Not Pick):");
        for (List<Integer> subset : subsetsRecursive) {
            System.out.println(subset);
        }
    }
}
