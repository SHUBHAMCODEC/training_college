package thoughtWorks;

public class move_negative_atEnd {
    
    // below function will give time complexity of O(n) but vales will not be in-Place means values can chage thier order.


    private static void helperFunction(int arr[]){

        System.out.println("Array before the  execution of helperFunction\n");
        for(int i:arr){
            System.out.print(i+ " ");
        }
        System.out.println();
        int index=arr.length-1;
        int i=0;
        while(i<index){
            if(arr[i]<0){
                int temp=arr[i];
                arr[i]=arr[index];
                arr[index]=temp;
                
                index--;
                
            }else{
                i++;
            }
        }
        System.out.println("Array after execution of helperFunction");
        for(int j:arr){
            System.out.print(j+ " ");
        }
    }

    // this is the function which gives the time complexity of O(n) and as well as space complexity of O(n)-> issue,
    //  but the order of the elements will be preserve.

    private static void inPlace(int [] arr){
        int temp[]=new int[arr.length];

        int tempIndex=0;
        
        //adding the positive numbers at first 
        for(int num:arr){
            if(num>0){
                temp[tempIndex++]=num;
            }
        }

        //adding the negative numbers at last

        for(int num:arr){
            if(num<0){
                temp[tempIndex++]=num;
            }
        }

        // Copy temp back to original array
        System.arraycopy(temp, 0, arr, 0, arr.length);
        System.out.println("Array after execution of inPlace Function");
        for(int j:arr){
            System.out.print(j+ " ");
        }
    }
// this function , using the concept of merge sort but with little bit change for the required concept.
// this function takes the space and time complexity of O(n) and the order is also reserve.
    private static void mergeSort(int arr[],int l,int h){
        if(l>=h) return;

        int mid=l+(h-l)/2;

        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,h);
        merge(arr, l, mid, h);

    }

    private static void merge(int arr[],int l,int mid,int h){
        int i=0;
        int j=mid+1;

        while(i<=mid && arr[i]>0){
            i++;
        }

        while(j<=h && arr[j]>0){
            j++;
        }

        reverse(arr,i,mid);
        reverse(arr,j,mid);
        reverse(arr,i,j-1);

        
    }

    private static void reverse(int arr[],int low,int high){
        while(low<high){
            int temp=arr[low];
            arr[low]=arr[high];
            arr[high]=temp;
            low++;high--;
        }
    }

    public static void main(String[] args){
        System.out.println("----------------------------------------1st function-----------------------");
        helperFunction(new int[]{4, 5, -8, -4, -2, -1, 5, 6, 8, -2, 4, -6, -89, -12, -56, 100, 101, 147});
        System.out.println("\n\n");

        System.out.println("----------------------------------------2nd function-----------------------");
        inPlace(new int[]{-2, -1, 5, 6, 8, -2, 4, -6, -89, -12});
        System.out.println("\n\n");

        System.out.println("----------------------------------------3rd function-----------------------");
        int arre[] = {-45, -78, -89, -55, 1, 2, 3, 46, 45, -99, -101, -144, 250};
        mergeSort(arre, 0, arre.length - 1);
        
        System.out.println("Array after execution of mergeSort Function");
        for (int p : arre) {
            System.out.print(p + " ");
        }
        System.out.println();
    }
    
}
