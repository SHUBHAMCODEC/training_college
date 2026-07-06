package july;

public class reverseArray {
    private static void helper(int [] arr){
        int low=0,high=arr.length-1;
        System.out.println("array before reverse is: ");
        for(int i:arr){
            System.out.print(i+" ");
        }
        while(low<high){
            int temp=arr[low];
            arr[low]=arr[high];
            arr[high]=temp;
        }

        System.out.println("array After reverse is: ");
        for(int i:arr){
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args) {
        helper(new int[]{1,2,3,4,50,60,70,80,90,100});
    }
}
