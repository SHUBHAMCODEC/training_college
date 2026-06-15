package thoughtWorks;

public class getMinDiff {


    private static void merge(int arr[],int l,int m,int h){

        int n1=m-l+1;
        int n2=h-m;

        int temp1[]=new int[n1];
        int temp2[]=new int[n2];

        for(int i=0;i<n1;i++){
            temp1[i]=arr[l+i];
        }
        for(int i=0;i<n2;i++){
            temp2[i]=arr[m+1+i];
        }


        int i=0,j=0,k=l;

        while(i!=temp1.length && j!=temp2.length){
            if(temp1[i]<temp2[j]){
                arr[k]=temp1[i];
                i++;k++;
            }else{
                arr[k]=temp2[j];
                j++;k++;
            }
        }

        while(i!=temp1.length){
            arr[k]=temp1[i];
            i++;k++;
        }

        while(j!=temp2.length){
            arr[k]=temp2[j];
            j++;k++;
        }
    }

    private static void mergeSort(int[] arr,int l,int h){

        if(l<h){
            int mid=l+((h-l)/2);


            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, h);

            merge(arr,l,mid,h);

            
        }
    }
    private static void helper(int arr[],int k){
         int n = arr.length;
        if (n == 1) {
            System.out.println("Minimum heights: 0");
            return;
        }
        mergeSort(arr,0,n-1);

        int ans=arr[n-1]-arr[0];

        int lowest=arr[0]+k;
        int highest=arr[n-1]-k;
        for(int i=0;i<n-1;i++){
            if (arr[i + 1] - k < 0) {
                continue;
            }

            int minHeight = Math.min(lowest, arr[i + 1] - k);
            int maxHeight = Math.max(highest, arr[i] + k);

            ans = Math.min(ans, maxHeight - minHeight);
        }

        System.out.println("Minimum heights: " + ans);
    }
    public static void main(String args[]){
        int arr[]={3, 9, 12, 16, 20};
        int k=3;
        helper(arr, k);
    }
}
