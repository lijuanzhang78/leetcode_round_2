package Passed;

public class SumRootToLeafNumber_2nd {
	int sum;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        
        sum = 0;
        helper(root, 0);
        return sum;
    }
    
    void helper(TreeNode root, int pathSum) {
        if (root.left == null && root.right == null) sum += (pathSum*10 + root.val);
        if (root.left != null) helper(root.left, pathSum*10+root.val);
        if (root.right != null) helper(root.right, pathSum*10 + root.val);
    }	 
}
