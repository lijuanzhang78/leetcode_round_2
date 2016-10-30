package Backtracking;

public class PermutationII {
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        
        helper(nums,res,visited,new ArrayList<Integer>());
        return res;
    }
    
    void helper(int[] nums, List<List<Integer>> res, boolean[] visited, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
            visited[i] = true;
            list.add(nums[i]);
            helper(nums,res,visited,list);
            visited[i] = false;
            list.remove(list.size()-1);
        }
}
