package BinaryTree;

// 类似于 preorder
public class BinaryTreeLongestConsequtiveSequence_preorder {
	int res = Integer.MIN_VALUE;
    public int longestConsecutive(TreeNode root) {
        helper(root, 0, root);
        return res == Integer.MIN_VALUE? 0 : res;
    }    
    
    void helper(TreeNode root, int curr, TreeNode prev) {
        if (root == null) return;
        if (root.val == prev.val+1) {
            curr++;
        } else {
            curr = 1;
        }
        res = Math.max(res,curr);
        helper(root.left, curr, root);
        helper(root.right, curr, root);
    }
}
