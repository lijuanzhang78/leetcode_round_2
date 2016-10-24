package BinaryTree;

public class PathSumIII {
	public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        
        return pathSumFrom(root, sum) + pathSum(root.left,sum) + pathSum(root.right,sum);
    }
    
    private int pathSumFrom(TreeNode root, int sum) {
        if (root == null) return 0;
        int count = 0;
        if (root.val == sum) count++;
        return count+pathSumFrom(root.left,sum-root.val)+pathSumFrom(root.right,sum-root.val);
    }
}
