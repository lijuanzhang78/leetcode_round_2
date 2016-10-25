package Backtracking;

// 不需要sort array
// 其实就是面临很多选择，择其一，改变状态（visited，添加元素），然后再改变选择，revert状态
//
public class Permutation {
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        
        boolean[] visited = new boolean[nums.length];
        helper(res,nums,new ArrayList<Integer>(),visited);
        return res;
    }
    
    private void helper(List<List<Integer>> res, int[] nums, List<Integer> list, boolean[] visited) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            list.add(nums[i]);
            helper(res,nums,list,visited);
            visited[i] = false;
            list.remove(list.size()-1);
        }
    }
}
