package DFS;

public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        helper(res,root,"");
        return res;
    }
    
    void helper(List<String> res, TreeNode root, String prev) {
        if (root.left == null && root.right == null) {
            String s = prev+"->"+root.val;
            res.add(s.substring(2));
            return;
        }
        if (root.left != null) helper(res,root.left,prev+"->"+root.val);
        if (root.right != null) helper(res,root.right,prev+"->"+root.val);
    }
}
