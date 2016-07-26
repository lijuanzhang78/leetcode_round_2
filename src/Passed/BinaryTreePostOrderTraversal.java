package Passed;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostOrderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();  
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode prev = null;
        
        // push left most nodes into stack
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
        
        while(stack.size() > 0) {
            root = stack.peek();
            if (root.right != null && prev != root.right) {
                    root = root.right;
                    while (root != null) {
                        stack.push(root);
                        root = root.left;
                    }
            } else {
                res.add(root.val);
                prev = stack.pop();
            }
        }
            return res;
    }
}
