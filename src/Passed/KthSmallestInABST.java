package Passed;

import java.util.LinkedList;

public class KthSmallestInABST {
	 public int kthSmallest(TreeNode root, int k) {
	        if (root == null) return 0;
	        
	        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
	        int count = 0;
	        
	        while (root != null) {
	            stack.push(root);
	            root = root.left;
	        }
	            
	         while(!stack.isEmpty()) {
	             root = stack.pop();
	             if(++count == k) {
	                 break;
	             }
	             
	             if (root.right != null) {
	                 root = root.right;
	                 while(root != null) {
	                    stack.push(root);
	                    root = root.left;
	                }
	            }  
	        }
	        return root.val;
	    }
}
