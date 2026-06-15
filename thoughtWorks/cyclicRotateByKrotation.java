package thoughtWorks;

public class cyclicRotateByKrotation {

    private static void helperRotation(int arr[],int k){
           
        int rotate=(k % arr.length);
        while(rotate>0){
            int temp=arr[arr.length-1];
            for(int i=arr.length-1;i>0;i--){
                arr[i]=arr[i-1];
            }
            arr[0]=temp;

            rotate--;
        }

        System.out.println("Array After rotation: ");
        for(int i:arr){
            System.out.print(i+" ");
        }

        System.out.println();
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8,9,10};
         System.out.println("Array Before rotation: ");
        for(int i:arr){
            System.out.print(i+" ");
        }

        System.out.println("\n\n");

        helperRotation(arr,2);
        helperRotation(arr, 222);
        helperRotation(arr, 15);
        helperRotation(arr, 35);
        helperRotation(arr, 9);
        helperRotation(arr, 7);
    }
}
