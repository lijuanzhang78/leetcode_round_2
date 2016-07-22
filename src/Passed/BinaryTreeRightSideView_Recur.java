package Passed;

public class BinaryTreeRightSideView_Recur {
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        
        rightView(root, res, 0);
        return res;
    }
    
    void rightView(TreeNode node, List<Integer> res, int currDepth) {
        if (node == null) return;
        
        if (res.size() == currDepth) res.add(node.val);
        rightView(node.right, res, currDepth+1);
        rightView(node.left,  res, currDepth+1);
    }
}
