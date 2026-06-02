public class removeduplicates {
    public static void main(String[] args){
        int arr[]={1,1,1,2,2,3,4,5,5,6,6,70,70};
        int i=0;
        for(int j=1;j<arr.length;j++){
            if(arr[i]!=arr[j]){
                i++;
                arr[i]=arr[j];
            }
        }

        System.out.println("List:");
        for(int p:arr){
            System.out.print(p+" ");
        }
    }
}
