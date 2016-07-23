package Passed;

public class BinaryTreePaths {
	   public List<String> binaryTreePaths(TreeNode root) {
	        List<String> res = new ArrayList<String>();
	        if (root == null) return res;
	        helper(res, root, "");
	        return res;
	    }
	    
	    void helper(List<String> res, TreeNode curr, String s) {
	        if (curr.left == null && curr.right == null) res.add(s + curr.val);
	        if (curr.left != null) helper(res, curr.left, s + curr.val + "->");
	        if (curr.right != null) helper(res, curr.right, s + curr.val + "->");
	    }
}
