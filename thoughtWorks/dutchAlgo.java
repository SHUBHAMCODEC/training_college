package thoughtWorks;

public class dutchAlgo {

    private static void helper(int arr[]){
        int low=0,mid=0,high=arr.length-1;
        System.out.println("the array before the execution of dutch national flag algo: ");
        for(int i:arr){
            System.out.print(i+" ");
        }
        while(mid<=high){
            if(arr[mid]==0){
                int temp=arr[low];
                arr[low]=arr[mid];
                arr[mid]=temp;
                
                low++;
                mid++;
            }else if(arr[mid]==1){
                mid++;
            }
            else if(arr[mid]==2){
                int temp=arr[mid];
                arr[mid]=arr[high];
                arr[high]=temp;
                // Fix: Decrement high, do NOT increment mid yet
                high--;
                
            }
        }

        System.out.println("----------------------------------------------------------------------");
        System.out.println("the array after the execution of dutch national flag algo: ");
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
    public static void main(String[] args) {
        helper(new int[]{0,1,0,1,0,1,2,0,1,0,2,2});
    }
}
