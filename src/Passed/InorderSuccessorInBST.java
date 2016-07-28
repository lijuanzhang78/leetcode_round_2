package Passed;

public class InorderSuccessorInBST {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        TreeNode parent = null;
        
        if (p.right != null) {
            p = p.right;
            while (p.left != null) {
                p = p.left;
            }
            return p;
        } else {
            while(root != null) {
                if (root.val > p.val) {
                    parent = root;
                    root = root.left;
                } else if (root.val < p.val) {
                    root = root.right;
                } else {
                    return parent;
                }
            }
        }
        return null;
    }
}
