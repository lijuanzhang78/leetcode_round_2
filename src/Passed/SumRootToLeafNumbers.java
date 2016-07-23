package Passed;

public class SumRootToLeafNumbers {
	public int sumNumbers(TreeNode root) {
        List<String> path = new ArrayList<String>();
        if (root == null) return 0;
        
        helper(path, root, "");
        
        int sum = 0;
        for(String s : path) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }
    
    void helper(List<String> path, TreeNode root, String s) {
        if (root.left == null && root.right == null) path.add(s + root.val);
        if (root.left != null) helper(path, root.left, s + root.val);
        if (root.right != null) helper(path, root.right, s + root.val);
    }
}
