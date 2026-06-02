public class sort0s1s2s {
    public static void main(String [] args){
        int [] arr={0,0,1,1,1,0,2,2,2};
        int low=0; int mid=0; int high=arr.length-1;
// low will point to the end of 0 and mid will point to end of 1 and high will point end of 2
        while(mid<high){
            if(arr[mid]==0){
                int temp=arr[low];
                arr[low]=arr[mid];
                arr[mid]=temp;

                mid++; low++;
        }else if(arr[mid]==1){
            mid++;
        }else if(arr[mid]==2){
            int temp=arr[mid];
            arr[mid]=arr[high];
            arr[high]=temp;

            high--;
        }

    }

    System.out.println("list: ");
    for(int i:arr){
        System.out.print(i+" ");
    }
}
}
