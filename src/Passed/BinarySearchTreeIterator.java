package Passed;

import java.util.LinkedList;

public class BinarySearchTreeIterator {
	LinkedList<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new LinkedList<TreeNode>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (!stack.isEmpty());
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode curr = stack.pop();
        int nextVal = curr.val;
        if (curr.right != null) {
            curr = curr.right;
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
        }
        return nextVal;
    }
}
