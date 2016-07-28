package Passed;

public class LowestCommonAncestorOfABinaryTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) {
            return root;
        }
        
        TreeNode left_result = lowestCommonAncestor(root.left, p, q);
        TreeNode right_result = lowestCommonAncestor(root.right, p, q);
        if (left_result != null && right_result != null) {
            return root;
        }
        
        if (left_result != null) {
            return left_result;
        }
        if (right_result != null) {
            return right_result;
        }
        return null;
    }
}
