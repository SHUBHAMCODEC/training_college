package thoughtWorks;

public class minimumAndMaximumInArray {
    private static void helper(int []arr){
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i:arr){
            if(i<min){
                min=i;
            }
            if(i>max){
                max=i;
            }
        }

        System.out.println("MIN VALUE : "+ min+" and MAX VALUE: "+ max);
    }


    public static void main(String[] args) {
        int arr[]={291,4,5,2,03,07,8,25,24,129,16,18,36,-54,48,43,47,39,23,20,17};
        helper(arr);
    }
}
