package Passed;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInOrderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();  
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        
        // push left most nodes into stack
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
        
        while(stack.size() > 0) {
            root = stack.pop();
            res.add(root.val);
            if (root.right != null) {
                root = root.right;
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(1);
		
		new BinaryTreeInOrderTraversal().inorderTraversal(root);		
	}
}
