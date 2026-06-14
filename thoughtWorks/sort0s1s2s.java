package thoughtWorks;
// Dutch National Flag ALgorithm 

public class sort0s1s2s {

    private static void helper(int [] arr){

        int low=0,mid=0,high=arr.length-1;


        System.out.println("Before sorting: ");

        for(int i:arr){
            System.out.print(i+" ");
        }
        while(mid<=high){
            if(arr[mid]==0){
                int temp=arr[low];
                arr[low]=arr[mid];
                arr[mid]=temp;
                
                low++;mid++;
            }else if(arr[mid]==1){
                mid++;
            }else if(arr[mid]==2){
                int temp=arr[mid];
                arr[mid]=arr[high];
                arr[high]=temp;
                
                high--;
            }
        }
        System.out.println();
        System.out.println();
        System.out.println("After sorting: ");

        for(int i:arr){
            System.out.print(i+" ");
        }
       
    }
    public static void main(String[] args) {
        int arr[]={1,0,0,0,1,1,2,2,1,0,2,2,1,0,2,1};
        helper(arr);
    }
}
