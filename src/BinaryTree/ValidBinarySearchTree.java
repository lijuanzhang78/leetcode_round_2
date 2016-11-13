package BinaryTree;

public class ValidBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        TreeNode prev = null;
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (prev != null && prev.val >= curr.val) return false;
            prev = curr;
            curr = curr.right;
        }
        
        return true;
    }
}
