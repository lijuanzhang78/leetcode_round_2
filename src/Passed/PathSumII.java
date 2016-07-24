package Passed;

public class PathSumII {
	 public List<List<Integer>> pathSum(TreeNode root, int sum) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        if (root == null) return res;
	        List<Integer> list = new ArrayList<Integer>();
	        helper(root, res, list, sum);
	        
	        return res;
	    }
	    
	    void helper(TreeNode root, List<List<Integer>> res, List<Integer> list, int sum) {
	        if (root == null) return;
	        list.add(root.val);
	        
	        if (root.left == null && root.right == null && sum == root.val) {
	            res.add(new ArrayList<Integer>(list));
	            list.remove(list.size() - 1);
	            return;
	        } else {
	            helper(root.left, res, list, sum - root.val); 
	            helper(root.right, res, list, sum - root.val);
	            list.remove(list.size() - 1);
	        }
	    }
}
