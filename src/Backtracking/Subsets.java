package Backtracking;

public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        res.add(new ArrayList<>());
        helper(res,nums,new ArrayList<Integer>(), 0);
        return res;
    }
    
    void helper(List<List<Integer>> res, int[] nums, List<Integer> list, int start) {
        if (start == nums.length) return;
        
        for(int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            res.add(new ArrayList<Integer>(list));
            helper(res,nums,list,i+1);
            list.remove(list.size()-1);
        }
    }
}
