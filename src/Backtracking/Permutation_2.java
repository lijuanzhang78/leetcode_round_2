package Backtracking;

public class Permutation_2 {
	public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<List<Integer>>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.length];
        helper(res,nums,temp,visited);
        return res;        
    } 
    
    void helper(List<List<Integer>> res, int[] nums, List<Integer> temp, boolean[] visited) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<Integer>(temp));
            return;            
        }
        
        for(int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            temp.add(nums[i]);
            visited[i] = true;
            
            helper(res,nums,temp,visited);
            visited[i] = false;
            temp.remove(temp.size()-1);            
        }
    }
}
