package BinaryTree;

public class BalancedTree {
	 public boolean isBalanced(TreeNode root) {
	        return getHeight(root) != Integer.MIN_VALUE;   
	    }
	    
	    private int getHeight(TreeNode root) {
	        if (root == null) return 0;
	        int leftH = getHeight(root.left);
	        if (leftH == Integer.MIN_VALUE) return Integer.MIN_VALUE;
	        int rightH = getHeight(root.right);
	        if (rightH == Integer.MIN_VALUE) return Integer.MIN_VALUE;
	        if (Math.abs(leftH-rightH) > 1) return Integer.MIN_VALUE;
	        return Math.max(leftH, rightH) + 1;
	    }
}
