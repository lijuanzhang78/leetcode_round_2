package DFS;

public class SymmetricTree {
	 public boolean isSymmetric(TreeNode root) {
	        if (root == null) return true;
	        return isSymmetric(root.left, root.right);
	    }
	    
	    boolean isSymmetric(TreeNode left, TreeNode right) {
	        if (left == null && right == null) return true;
	        if (left == null || right == null) return false;
	        
	        if (left.val == right.val) {
	            return isSymmetric(left.right,right.left) && isSymmetric(left.left, right.right);
	        } else {
	            return false;
	        }
	    }
}
