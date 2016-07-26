package Passed;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        
        TreeNode root = buildBST(nums, 0, nums.length-1);
        return root;
    }
    
    TreeNode buildBST(int[] nums, int low, int high) {
        if (low > high) return null;
        
        int mid = low + (high - low)/2;
        
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, low, mid - 1);
        root.right = buildBST(nums, mid+1, high);
        
        return root;
    }
}
