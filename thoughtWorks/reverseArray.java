package thoughtWorks;

public class reverseArray {

    private static void helper(int []arr){
        int low=0,high=arr.length-1;


        System.out.println("before reversal: ");
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
        while(low<high){
            int temp=arr[low];
            arr[low]=arr[high];
            arr[high]=temp;

            low++;
            high--;
        }
        
        System.out.println("After reversal: ");
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
        
    }
    
    
    private static void recur(int cnt,int n,int index,int[] arr){ // main function for the code
        if(cnt==n){
            return ;
        }
        
        int element=arr[cnt];
        recur(cnt+1,n,index-1,arr);
        arr[index]=element;
    }
    static int arr[]={1,5,8,2,4,7,9,12,10,17,19,22,25,28,35};
    public static void main(String [] args){
        
        // helper(arr);
        recur(0, arr.length, arr.length-1, arr);
        System.out.println("After reversal: ");
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
