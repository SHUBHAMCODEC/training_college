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
            temp1[i]=arr[m+1+i];
        }


        int i=0,j=0,k=0;

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

        while(l<h){
            int mid=l+((h-l)/2);


            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, h);

            merge(arr,l,m,h);
        }
    }
    private static void helper(int arr[]){
        mergeSort(arr,0,arr.length);
    }
    public static void main(String args[]){

    }
}
