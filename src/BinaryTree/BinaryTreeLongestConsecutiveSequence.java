// 类似于post order
// 先处理左右children 再处理parent

package BinaryTree;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreeLongestConsecutiveSequence {
	int res = Integer.MIN_VALUE;
    public int longestConsecutive(TreeNode root) {
        int curr = helper(root);
        return Math.max(curr,res);
    }    
    
    int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        
        int curr = 1;
        if (root.left != null && root.val == root.left.val - 1) curr = left + 1;
        if (root.right != null && root.val == root.right.val - 1) curr = Math.max(curr,right+1);
        res = Math.max(res,curr);
        return curr;
    }
	
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(1);
    	TreeNode node3 = new TreeNode(3);
    	root.right = node3;
    	TreeNode node2 = new TreeNode(2);
    	node3.left = node2;
    	TreeNode node4 = new TreeNode(4);
    	node3.right = node4;
    	TreeNode node5 = new TreeNode(5);
    	node4.right = node5;	
    	int res = new BinaryTreeLongestConsecutiveSequence().longestConsecutive(root);
    }
}
