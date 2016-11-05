package DFS;

public class SumRootToLeafNumbers2 {
	public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return sumNumbers(root,0);
    }
    
    public int sumNumbers(TreeNode root, int prev) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return prev*10 + root.val;
            
        return sumNumbers(root.left, prev*10 + root.val) + sumNumbers(root.right, prev*10+root.val);
    }
}
