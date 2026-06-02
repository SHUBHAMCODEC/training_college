import java.util.*;
class rotationArray{

    private static void reverse(int [] arr, int i,int j){
        if(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            reverse(arr,i+1,j-1);
        }
        
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int [] arr={1,2,3,4,7,8,9};
        System.out.print("original array:");
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("Enter the value how many times you want ");
        int k=sc.nextInt();
        int n=arr.length;
        k=k%n;
        reverse(arr,0,n-1);
        reverse(arr,0,k-1);
        reverse(arr,k,n-1);

        for(int i:arr){
            System.out.print(i+" ");
        }

    }
}