package Passed;

public class PathSum {
	 public boolean hasPathSum(TreeNode root, int sum) {
	        if (root == null) return false;
	        return helper(root, sum, 0);
	    }
	    
	    boolean helper(TreeNode root, int target, int currsum) {
	        if (root == null) return false;
	        currsum += root.val;
	        if (root.left == null && root.right == null) {
	            if (currsum == target) return true;
	            else return false;
	        }
	        
	        return helper(root.left, target, currsum) || helper(root.right, target, currsum);
	    }
}
