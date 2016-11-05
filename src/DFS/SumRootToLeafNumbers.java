package DFS;

public class SumRootToLeafNumbers {
	public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        List<String> res = new ArrayList<>();
        sumNumber(root,"",res);
        int sum = 0;
        for(String s : res) {
            sum += Integer.valueOf(s);
        }
        return sum;
    }
    
    public void sumNumber(TreeNode root, String s, List<String> res) {
        if (root.left == null && root.right == null) {
            res.add(s+root.val);
            return;
        }
        
        if (root.left != null) sumNumber(root.left, s+root.val,res);
        if (root.right != null) sumNumber(root.right, s+root.val,res);
    }
}
