package Passed;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();  
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        
        // push left most nodes into stack
        while(root != null) {
            stack.push(root);
            res.add(root.val);
            root = root.left;
        }
        
        while(stack.size() > 0) {
            root = stack.pop();
            if (root.right != null) {
                root = root.right;
                while (root != null) {
                    stack.push(root);
                    res.add(root.val);
                    root = root.left;
                }
            }
        }
        return res;
    }
}
