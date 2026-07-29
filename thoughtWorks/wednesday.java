import java.util.Arrays;

public class wednesday {
    
    private static void bubbleSort(int[] arr){
        System.out.print("ArrayBefore Bubble Sort: ");
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j] > arr[j + 1]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        System.out.print("ArrayAfter Bubble Sort: ");
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    
    private static void SelectionSort(int [] arr){
        
        System.out.print("ArrayBefore Selection Sort: ");
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
        for(int i=0;i<arr.length-1;i++){
            
            int minIndex=i;
            for(int j=i+1;j<arr.length-1;j++){
                if(arr[j] < arr[minIndex]){
                    minIndex=j;
                }
            }
            
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        System.out.print("ArrayAfter Selection Sort: ");
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    private static void insertionSort(int[] arr){
        System.out.print("ArrayBefore insertion Sort: ");
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
        for(int i=0;i<arr.length;i++){
            int key = arr[i];
            
            int j=i;
            while(j>=0 && arr[j]>key){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        System.out.print("ArrayAfter insertion Sort: ");
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    private static void mergeSort(int[] arr,int low,int high){
        
        System.out.print("ArrayBefore Merge Sort: ");
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merger(arr, low, mid, high);
        }

        System.out.print("ArrayAfter Merge Sort: ");
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    private static void merger(int [] arr,int low,int mid,int high){
        int n=mid-low+1;
        int m=high-mid;

        int[] arr1=new int[n];
        int[] arr2=new int[m];

        for(int i=0;i<n;i++){
            arr1[i]=arr[low+1];
        }
        for(int i=0;i<m;i++){
            arr2[i]=arr[mid+i+1];
        }

        int i=0,j=0;
        int k=low;
        while(i<n && j<m){
            if(arr1[i]<arr2[j]){
                arr[k++]=arr1[i++];
            }else{
                arr[k++]=arr2[j++];
            }
        }
        while(i<n){
            arr[k++]=arr1[i++];
        }
        while(j<m){
            arr[k++]=arr2[j++];
        }
    }

    private static void QuickSort(int arr[],int low,int high){
        if (low < high) {
            int pIndex = partition(arr, low, high);
            quickSort(arr, low, pIndex - 1);
            quickSort(arr, pIndex + 1, high);
        }
    }
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }


    private static void DutchFlag(int arr[]){
        int low=0, mid=0,high=arr.length-1;

       System.out.println("Before Dutch Flag: " + Arrays.toString(arr));
      
        while (mid <= high) {
            if (arr[mid] == 0) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;
                high--;
            }
        }
        System.out.println("After Dutch Flag:  " + Arrays.toString(arr));
    }
    public static void main(String[] args) {
        
    }
}
