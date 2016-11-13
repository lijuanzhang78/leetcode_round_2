package BinaryTree;

public class ClosestBinarySearchTreeValue {
	 public int closestValue(TreeNode root, double target) {
	        if (root == null) return 0;
	        return helper(root, target, root.val);
	    }
	    private int helper(TreeNode root, double target, int val) {
	        if (root == null) return val;
	        if (Math.abs(root.val-target) < Math.abs(val-target)) val = root.val;
	        if (root.val < target) {
	            return helper(root.right,target,val);
	        } else if (root.val > target) {
	            return helper(root.left,target,val);
	        } else {
	            return val;
	        }
	    }
}
