package Passed;

public class SubsetsII {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<>();
        for(int size = 0; size <= n; size++) {
            helper(nums, res, list, size, 0);
        }
        return res;
    }
    
    private void helper(int[] nums, List<List<Integer>> res, List<Integer> list, int size, int start) {
        if (list.size() == size) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        if (start >= nums.length) return;
        for(int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) continue;
            
            list.add(nums[i]);
            helper(nums,res,list,size,i+1);
            list.remove(list.size()-1);
        }
        return;
    }
}
