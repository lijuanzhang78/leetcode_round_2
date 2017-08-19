package Backtracking;

public class Subsets_2 {
	public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<List<Integer>>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        
        helper(res,temp,0,nums);
        res.add(new ArrayList<Integer>());
        return res;
    }
    
    void helper(List<List<Integer>> res, List<Integer> temp, int start, int[] nums) {
        for(int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            res.add(new ArrayList<Integer>(temp));
            helper(res,temp,i+1,nums);
            temp.remove(temp.size()-1);            
        }    
    }  
}
