package Passed;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, 0, inorder.length - 1, map);
    }
    
    TreeNode helper(int[] preorder, int[] inorder, int prenode, int instart, int inend, Map<Integer, Integer> map) {
        if (instart > inend) return null;
        int mid = map.get(preorder[prenode]);
        TreeNode root = new TreeNode(inorder[mid]);
        int numleft = mid - instart + 1;
        
        root.left = helper(preorder, inorder, prenode+1, instart, mid-1, map);
        root.right = helper(preorder, inorder, prenode+numleft, mid+1, inend, map);
        return root;
    }
}
