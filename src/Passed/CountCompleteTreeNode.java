package Passed;

public class CountCompleteTreeNode {
	public int countNodes(TreeNode root) {
        if (root == null) return 0;
        
        int leftH = getLeftHeight(root);
        int rightH = getRightHeight(root);
        
        if (leftH == rightH) {
            return (2<<(leftH-1)) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
    
    int getLeftHeight(TreeNode root) {
        int height = 0;
        while(root != null) {
            root = root.left;
            height++;
        }
        return height;
    }
    
    int getRightHeight(TreeNode root) {
        int height = 0;
        while(root != null) {
            root = root.right;
            height++;
        }
        return height;
    }

}
