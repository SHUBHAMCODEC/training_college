package thoughtWorks;

public class move_negative_atEnd {

    private static void helperFunction(int arr[]){

        System.out.println("Array before the  execution of helperFunction/n");
        for(int i:arr){
            System.out.print(i+ " ");
        }
        int index=arr.length-1;
        int i=0;
        while(i<index){
            if(arr[i]<0){
                int temp=arr[i];
                arr[i]=arr[index];
                arr[index]=temp;
                
                index--;
                
            }
            i++;
        }
        System.out.println("Array after execution of helperFunction");
        for(int j:arr){
            System.out.print(j+ " ");
        }
    }
    public static void main(String[] args){
        helperFunction(new int[]{4,5,-8,-4,-2,-1,5,6,8,-2,4,-6,-89,-12,-56,100,101,147});
    }
    
}
