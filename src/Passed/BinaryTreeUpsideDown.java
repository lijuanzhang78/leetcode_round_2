package Passed;

public class BinaryTreeUpsideDown {
	public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return null;
        if (root.left != null) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            TreeNode res = upsideDownBinaryTree(left);
            
            left.left = right;
            left.right = root;
            root.left = null;
            root.right = null;
            return res;
            
        } else {
            return root;
        }
    }
}
