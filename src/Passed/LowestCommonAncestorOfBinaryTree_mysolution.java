package Passed;

public class LowestCommonAncestorOfBinaryTree_mysolution {
	 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        if (root == null) return null;
	        
	        if (search(p, q)) return p;
	        if (search(q, p)) return q;
	        
	        return helper(root, p, q);
	    }
	    
	    TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
	        if (search(root.left, p) && search(root.left, q)) {
	            root = root.left;
	            return helper(root, p, q);
	        }
	        
	        if(search(root.right, p) && search(root.right, q)) {
	            root = root.right;
	            return helper(root, p, q);
	        }
	        
	        return root;
	    }
	    
	    boolean search(TreeNode source, TreeNode p) {
	        if (source == null) return false;
	        if (source == p) return true;
	        if(search(source.left, p) || search(source.right, p)) return true;
	        return false;
	    }
}
