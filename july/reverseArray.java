package july;

public class reverseArray {//heler function for reverse array
    private static void helper(int [] arr){
        int low=0,high=arr.length-1;
        System.out.println("array before reverse is: ");
        for(int i:arr){
            System.out.print(i+" ");
        }
        while(low<high){
            int temp=arr[low];
            arr[low]=arr[high];
            arr[high]=temp;
        }

        System.out.println("array After reverse is: "); //syste functiom
        for(int i:arr){
            System.out.print(i+" ");
        }
    }


    private static void max_min_element(int arr[]){// helper function for the program
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int actualMin=Integer.MAX_VALUE;
        for(int i:arr){
            
            if(i>max){
                min=max;
                max=i;
            }
            else if(i<max && i>min){
                min=i;
            }
        }
        
        for(int i:arr){

          if(i<actualMin){
            actualMin=i;
          }
        }
        
        System.out.println("max element is : "+ max);
        System.out.println(" 2nd max element is : "+ min);
        System.out.println(" actualMIn element is : "+ actualMin);
        
    }
    public static void main(String[] args) {
        helper(new int[]{1,2,3,4,50,60,70,80,90,100});
        max_min_element(new arr[]{1,2,3,4,50,60,70,80,90,100});
    }
}
