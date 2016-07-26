package Passed;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return helper(inorder.length - 1, 0, inorder.length - 1, inorder, postorder, map);
    }
    
    TreeNode helper(int postnode, int instart, int inend, int[] inorder, int[] postorder, Map<Integer, Integer> map) {
        if (instart > inend) return null;
        
        TreeNode root = new TreeNode(postorder[postnode]);
        int mid = map.get(postorder[postnode]);
        int numright = inend - mid;
        
        root.right = helper(postnode - 1, mid+1, inend, inorder, postorder, map);
        root.left = helper(postnode - numright -1, instart, mid-1, inorder, postorder, map);
        
        return root;
    }
}
