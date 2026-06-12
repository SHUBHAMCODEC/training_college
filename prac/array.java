package prac;

public class array {

    private static void secondElement(int arr[]){
        int highest=0;
        int sec_high=Integer.MIN_VALUE;
        if(arr.length<=1){
            System.out.println("no 2nd highest value exist");
            return;
        }
        if(arr.length==2){
            if(arr[0]<arr[1]){
                 System.out.println("second Highest: "+arr[0]);
                 return;
            }else{
                 System.out.println("second Highest: "+arr[1]);
                 return;
            }
        }

        for(int i=0;i<arr.length;i++){
            if(arr[i]>highest){
                sec_high=highest;
                highest=arr[i];
            }else if(arr[i]<highest && sec_high>arr[i]){
                sec_high=arr[i];
            }
        }

        System.out.println(" Highest: "+highest);
        System.out.println("second Highest: "+sec_high);
    }

    private static void swap()
    private static void rotateByK(int [] arr){

    }
    public static void main(String[] args) {
        secondElement(new int[]{1,2,4,7,5,8,10,12,15,6});
    }
}
