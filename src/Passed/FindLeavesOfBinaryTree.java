package Passed;

public class FindLeavesOfBinaryTree {
	 public List<List<Integer>> findLeaves(TreeNode root) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        
	        dfs(root, res);
	        
	        return res;
	    }
	    
	    int dfs(TreeNode root, List<List<Integer>> res) {
	        if (root == null) return -1;
	        int level = Math.max(dfs(root.left, res), dfs(root.right,res)) + 1;
	        
	        if (res.size() <= level) res.add(new ArrayList<Integer>());
	        res.get(level).add(root.val);
	        
	        return level;
	    }
}
