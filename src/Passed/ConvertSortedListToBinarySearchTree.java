package Passed;

public class ConvertSortedListToBinarySearchTree {
    ListNode node;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        node = head;
        int size = 0;
        ListNode runner = head;
        while (runner != null) {
            size++;
            runner = runner.next;
        }
        
        return helper(0, size-1);
    }
    
    TreeNode helper(int start, int end) { 
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        
        TreeNode left = helper(start, mid - 1);
        TreeNode root = new TreeNode(node.val);
        node = node.next;
        TreeNode right = helper(mid + 1, end);
        root.left = left;
        root.right = right;
        
        return root;
    }
}
