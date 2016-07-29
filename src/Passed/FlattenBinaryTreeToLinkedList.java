package Passed;

public class FlattenBinaryTreeToLinkedList {
	public void flatten(TreeNode root) {
        if (root == null) return;
        
        flatten(root.left);
        flatten(root.right);
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        if(left != null) root.right = left;
        root.left = null;
        
        if(left != null) {
            while (left.right != null) {
                left = left.right;
            }
            left.right = right;
        }
    }
}
