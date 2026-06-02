public class nonZero {
    public static void main(String[] args){
        int[] arr={1,2,3,0,0,4,5,3,79};

        int i=0;
        for(int j=0;j<arr.length;j++){
            if(arr[j]!=0){
                arr[i]=arr[j];
                i++;
            }
        }
        for(int j=i;j<arr.length;j++){
            arr[j]=0;
        }

        System.out.println("List:");
        for(int p:arr){
            System.out.print(p+" ");
        }
    }
}
