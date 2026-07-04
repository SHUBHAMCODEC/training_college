import java.util.ArrayList;
import java.util.List;

// public class permuteUnique { // older approch
//     List<List<Integer>> res=new ArrayList<>();
//     public List<List<Integer>> subsets(int[] nums) {
//         List<Integer> list=new ArrayList<>();
//         generate(list,nums,0);
//         return res;
//     }
//     public void generate(List<Integer> list,int[] nums,int index){
//         if(index==nums.length){
//             res.add(new ArrayList<>(list));
//             return;
//         }
//         list.add(nums[index]);
//         generate(list,nums,index+1);
//         list.remove(list.size()-1);
//         generate(list,nums,index+1);
//     }
// }



//newer approch


public void backtrack(int i, int[] nums, List<List<Integer>> res) {
    if (i == nums.length) {
        List<Integer> temp = new ArrayList<>();
        for (int x : nums) temp.add(x);
        res.add(temp);
        return;
    }

    Set<Integer> seen = new HashSet<>();

    for (int j = i; j < nums.length; j++) {
        if (seen.contains(nums[j])) continue;

        seen.add(nums[j]);

        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;

        backtrack(i + 1, nums, res);

        tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp; // backtrack
    }
}

public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    backtrack(0, nums, res);
    return res;
}
