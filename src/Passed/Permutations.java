package Passed;

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        int n = nums.length;
        boolean[] visited = new boolean[n];
        
        helper(res, nums, visited, temp);
        return res;
    }
    
    void helper(List<List<Integer>> res, int[] nums, boolean[] visited, List<Integer> temp) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            
            temp.add(nums[i]);
            visited[i] = true;
            helper(res, nums, visited, temp);
            
            visited[i] = false;
            temp.remove(temp.size()-1);
        }
    } 

}
