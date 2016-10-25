package Backtracking;

// 需要sort数组
public class SubsetsII {
	 public List<List<Integer>> subsetsWithDup(int[] nums) {
	        List<List<Integer>> res = new ArrayList<>();
	        if (nums == null || nums.length == 0) return res;
	        Arrays.sort(nums);
	        res.add(new ArrayList<>());
	        helper(res, nums, new ArrayList<Integer>(), 0);
	        return res;
	    }
	    
	    private void helper(List<List<Integer>> res, int[] nums, List<Integer> list, int start) {
	        if (start == nums.length) return;
	        
	        for(int i = start; i < nums.length; i++) {
	            if (i > start && nums[i] == nums[i-1]) continue;
	            list.add(nums[i]);
	            res.add(new ArrayList<Integer>(list));
	            helper(res,nums,list,i+1);
	            list.remove(list.size()-1);
	        }
	    }
}
