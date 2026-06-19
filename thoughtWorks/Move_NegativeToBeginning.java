package thoughtWorks;

public class Move_NegativeToBeginning {

    private static void helper(int [] arr){

        System.out.println("before action: ");
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println();
        int low=0,mid=0;
        for( mid=0;mid<arr.length;mid++){
            if(arr[mid]<0){
                int temp=arr[low];
                arr[low]=arr[mid];
                arr[mid]=temp;
                
                low++;
            }
        }
        System.out.println("after action: ");
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println();
    }
    public static void main(String[] args){// main function for code
        int arr[]={-12, 11, -13, -5, 6, -7, 5, -3, -6};
        helper(arr);
    }
}
