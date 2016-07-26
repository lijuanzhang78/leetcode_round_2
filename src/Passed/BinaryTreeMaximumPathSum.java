package Passed;

public class BinaryTreeMaximumPathSum {
	int maxValue;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        maxValue = Integer.MIN_VALUE;
        maxPath(root);
        return maxValue;
    }
    
    int maxPath(TreeNode root) {
        if(root == null) return 0;
        int left = Math.max(0,maxPath(root.left));
        int right = Math.max(0,maxPath(root.right));
        maxValue = Math.max(maxValue, left+right+root.val);
        return Math.max(left+root.val, right+root.val);
    }
}
