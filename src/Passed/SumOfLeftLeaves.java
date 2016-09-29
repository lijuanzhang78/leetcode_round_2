package Passed;

public class SumOfLeftLeaves {
	int res = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return res;
    }
    
    private void helper(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                res += root.left.val;
            } else {
                helper(root.left);
            }
        }
        helper(root.right);
    }
}
