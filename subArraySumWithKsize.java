public class subArraySumWithKsize {

    private static void helper(int [] arr,int k){
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
        
    }
}
