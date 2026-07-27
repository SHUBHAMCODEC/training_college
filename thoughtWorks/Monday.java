package thoughtWorks;
// Arrays - Fundamentals & Problem Patterns

public class Monday {

    private static int Largest_Element_in_an_Array(int arr[]){
        int max=Integer.MIN_VALUE;
        for(int i:arr){
            if (i>max){
                max=i;
            }
        }

        return max;
    }

    private static int Second_Largest_Element(int arr[]){
        int max=Integer.MIN_VALUE;
        int secMax=Integer.MIN_VALUE;
        if(arr.length==1){
            return arr[0];
        }
        for(int i:arr){
            if(i>max){
                secMax=max;
                max=i;
            }else if (i<max && i>secMax) {
                secMax=i;
            }
        }

        return secMax;
    }

    private static boolean  Check_if_Array_is_Sorted(int [] arr){
        boolean status=true;

        for(int i=0;i<arr.length;i++){
            if(arr[i]>arr[i+1]){
                status=false;
                return status;
            }
        }

        return status;
    }

    private static int[] Reverse_an_Array(int [] arr){
        int low=0,high=arr.length-1;

        while(low<high){
            int temp=arr[low];
            arr[low]=arr[high];
            arr[high]=temp;

            low++;high--;
        }

        return arr;
    }

    private static int[] Left_Rotate_Array_by_One(int [] arr,int k){
        int n=arr.length;
        int actualRotation=k/n;

        while(actualRotation>0){
            int temp=arr[0];
            for(int i=1;i<n;i++){
                arr[i-1]=arr[i];
            }
        
            arr[n-1]=temp;
        }
        
        return arr;
            
    }
    public static void main(String[] args) {
        
    }
}
