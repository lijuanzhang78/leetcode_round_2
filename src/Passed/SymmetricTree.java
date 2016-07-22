package Passed;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }
    
    boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        
        return helper(left.right, right.left) && helper(left.left, right.right);
    }    
}
