import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
                    int temp=arr[j];
                    arr[j]=arr[j + 1];
                    arr[j + 1]=temp;
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
            for(int j=i+1;j<arr.length;j++){
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
        for(int i=1;i<arr.length;i++){
            int key = arr[i];
            int j=i-1;
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
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merger(arr, low, mid, high);
        }
    }

    private static void merger(int [] arr,int low,int mid,int high){
        int n=mid-low+1;
        int m=high-mid;

        int[] arr1=new int[n];
        int[] arr2=new int[m];

        for(int i=0;i<n;i++){
            arr1[i]=arr[low+i];
        }
        for(int i=0;i<m;i++){
            arr2[i]=arr[mid+i+1];
        }

        int i=0,j=0;
        int k=low;
        while(i<n && j<m){
            if(arr1[i]<=arr2[j]){
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
            QuickSort(arr, low, pIndex - 1);
            QuickSort(arr, pIndex + 1, high);
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
        System.out.println("Before Dutch Flag: " + Arrays.toString(arr));
        int low=0, mid=0,high=arr.length-1;
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



    private static void mergeIntervals(List<List<Integer>> ls) {
        // Handle empty or single interval cases
        if (ls == null || ls.size() <= 1) {
            return;
        }

        // 1. Sort intervals by their start values
        Collections.sort(ls, (a, b) -> Integer.compare(a.get(0), b.get(0)));

        List<List<Integer>> merged = new ArrayList<>();
        // Initialize with the first interval
        List<Integer> currentInterval = ls.get(0);
        merged.add(currentInterval);

        // 2. Iterate and merge remaining intervals
        for (int i = 1; i < ls.size(); i++) {
            List<Integer> nextInterval = ls.get(i);

            // Check if intervals overlap
            if (currentInterval.get(1) >= nextInterval.get(0)) {
                // Merge by updating the end time to the maximum end time
                currentInterval.set(1, Math.max(currentInterval.get(1), nextInterval.get(1)));
            } else {
                // Move to the next disjoint interval
                currentInterval = nextInterval;
                merged.add(currentInterval);
            }
        }

        // 3. Update the original list to reflect merged results
        ls.clear();
        ls.addAll(merged);
    }




    private static void binarySearch(int arr[],int target){
        int low=0;
        int high=arr.length-1;
        while(low<high){
            int mid=low+(high-low)/2;

            if(arr[mid]==target){
                System.out.println("element found on index: "+ mid);
            }else if(arr[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
    }

    private static int UpperBound(int arr[],int k){
        int low = 0, high = arr.length - 1;
        int ans = arr.length;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] > k){
                ans = mid;
                high = mid - 1; // Look on left side
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static int lowerBound(int[] arr, int k){
        int low = 0, high = arr.length - 1;
        int ans = arr.length; 
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] >= k){
                ans = mid;
                high = mid - 1; // Look on left side
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static void booleanCommand(int arr[],int k){
        ArrayList<Integer> ls=new ArrayList<>();
        int st=findRange(arr, k, true);
        ls.add(st);
        if(!ls.isEmpty()){
            int nd=findRange(arr, k, false);
            ls.add(nd);
        }
        System.out.println(ls);
    }
    private static int findRange(int arr[],int k,boolean ch){
        int low=0,high=arr.length-1;
        while(low<high){
            int mid=low+(high-low)/2;

            if(arr[mid]==k){
                if(ch==true){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
                return mid;
            }else if(arr[mid]>k){
                high=mid-1;
            }else{

            }
        }

        return 0;
    }

    private static int insertPosition(int arr[],int k){
        int low=0,high=arr.length-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(arr[mid]==k || arr[mid]<k){
                if(arr[mid]==k || arr[mid+1]>k){
                    return mid+1;
                }
            }else if(arr[mid]>k){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return -1;
    }

     private static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Target found
            if (nums[mid] == target) {
                return mid;
            }

            // Check if the left half is sorted
            if (nums[left] <= nums[mid]) {
                // Check if target lies within the sorted left half
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } 
            // Otherwise, the right half must be sorted
            else {
                // Check if target lies within the sorted right half
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        // Target not found
        return -1;
    }
    private static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If we are on an ascending slope, peak is to the right
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } 
            // If we are on a descending slope, mid could be a peak or peak is to the left
            else {
                right = mid;
            }
        }

        // Left and right converge to the peak element index
        return left;
    }
    public static void main(String[] args) {
        int[] data = {4, 2, 1, 3, 0, 2};
        bubbleSort(data.clone());
        SelectionSort(data.clone());
        insertionSort(data.clone());
        
        int[] mData = data.clone();
        System.out.println("Before Merge Sort: " + Arrays.toString(mData));
        mergeSort(mData, 0, mData.length - 1);
        System.out.println("After Merge Sort:  " + Arrays.toString(mData));
        
        int[] qData = data.clone();
        System.out.println("Before Quick Sort: " + Arrays.toString(qData));
        QuickSort(qData, 0, qData.length - 1);
        System.out.println("After Quick Sort:  " + Arrays.toString(qData));
        
        DutchFlag(new int[]{2, 0, 1, 2, 0, 1});
    }
}
