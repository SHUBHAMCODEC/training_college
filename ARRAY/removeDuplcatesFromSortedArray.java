class Solution {// we have to remove the duplicates from sorted array
    public int removeDuplicates(int[] nums) {
        int k = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;        
    }

    public static void main(String args[]){
        int[] nums={1,1,2,3,4,5,5,6,10,12,12,15,17,22,22,25,25,36,45,46,48,48,50,50,50};
        int[]arr2=removeDuplicates(nums);
        System.out.println(arr2);
    }
}
