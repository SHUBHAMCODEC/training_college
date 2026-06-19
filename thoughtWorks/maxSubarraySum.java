package thoughtWorks;

public class maxSubarraySum {

    private static void helper(int[] arr){  // kadane's Algorithm the optimal algo. for this.
        int sum=0,maxSum=0;

        for(int i:arr){
            sum+=i;
            if(sum<0){
                sum=0;
            }
            maxSum=Math.max(maxSum, sum);
        }

        if(maxSum==0){
            maxSum=arr[0];
        }

        System.out.println("Maximum SUbarray Sum is : "+maxSum);
    }
    public static void main(String[] args){
        int arr[]={-5432, -5432, -999, -12, -12, -1, 0, 0, 1, 12, 12, 999, 999, 5432};

        helper(arr);

        int arr2[]={-1, -10000, -50, -50, -2, -999, -5, -3, -10000, -1};
        helper(arr2);
    }
}
