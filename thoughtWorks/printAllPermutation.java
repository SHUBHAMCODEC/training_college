package thoughtWorks;

import java.util.Arrays;

public class printAllPermutation {

    private static void recurNumber(int[] arr, int i){ // function for generating permutation of numbers
        if(i==arr.length){
            System.out.println(Arrays.toString(arr));
            return;
        }

        for(int p=i;p<arr.length;p++){
            swap(arr,i,p);
            recurNumber(arr, i+1);
            swap(arr,i,p);
        }
    }

    private static void swap(int arr[],int x,int y){
        int temp=arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }


    private static void recurString(String s,String str){
        if(s.length()==0){
            System.out.println(str);
            return;
        }

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);

            String remaining=s.substring(0,i)+ s.substring(i+1);
            recurString(remaining, str+ch);
        }
    }
    public static void main(String[] args) {
        System.out.println("--- Number Permutations ---");
        int[] numArr = {1, 2, 3};
        recurNumber(numArr, 0);

        System.out.println("\n--- String Permutations ---");
        String testStr = "ABC";
        recurString(testStr, "");
    }
}
