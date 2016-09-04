package Passed;

public class PermutationII {
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.length];
        helper(res, temp, visited, nums);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> temp, boolean[] visited, int[] nums) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
            
            temp.add(nums[i]);
            visited[i] = true;
            helper(res,temp,visited,nums);
            temp.remove(temp.size()-1);
            visited[i] = false;
        }
    }
}
