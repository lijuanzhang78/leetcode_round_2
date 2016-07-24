package Passed;

public class BalancedBinaryTree_2nd {
	public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;
    } 
    
    int dfsHeight(TreeNode root) {
        if(root == null) return 0;
        
        int leftH = dfsHeight(root.left);
        if (leftH == -1) return -1;
        int rightH = dfsHeight(root.right);
        if (rightH == -1) return -1;
        
        if (Math.abs(leftH - rightH) > 1) return -1;
        return Math.max(leftH, rightH) + 1;
    }
}
