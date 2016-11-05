package DFS;

// 注意迭代的分支

public class MinimumDepthOfBinaryTree {
	 public int minDepth(TreeNode root) {
	        if (root == null) return 0;
	        if (root.left == null && root.right == null) return 1;
	        int minL = 0;
	        int minR = 0;
	        if (root.left == null) return minDepth(root.right)+1;
	        if (root.right == null) return minDepth(root.left)+1;
	        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	    }
}
