public class subArraySumWithKsize {

    private static int helper(int [] arr,int k){
        int sum=0;

        for(int i=0;i<k;i++){
            sum+=arr[i];
        }

        int maxSum=0;
        for(int i=k;i<arr.length;i++){
            sum+=arr[i];
            maxSum=sum-arr[i-k];
            maxSum=Math.max(sum,maxSum);
        }

        return maxSum;
    }
    public static void main(String[] args) {
        int arr[]={1,5,6,8,2,3,4,7,10,15,11,17,13};
        int k=3;
        System.out.println("sum is "+helper(arr, k) );
    }
}
