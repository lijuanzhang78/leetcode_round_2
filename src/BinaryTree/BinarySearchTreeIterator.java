package BinaryTree;

public class BinarySearchTreeIterator {
	Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        if (root != null) {
            TreeNode curr = root;
            stack.push(curr);
            pushLeft(curr);
        }
    }
    
    public void pushLeft(TreeNode root) {
        while(root.left != null) {
            stack.push(root.left);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (stack.isEmpty()) return false;
        return true;
    }

    /** @return the next smallest number */
    public int next() {
        int res = 0;
        if (hasNext()) {
            TreeNode curr = stack.pop();
            res = curr.val;
            if (curr.right != null) {
                curr = curr.right;
                stack.push(curr);
                pushLeft(curr);
            }
        } 
        return res;
    }	
}
