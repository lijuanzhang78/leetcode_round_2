package Passed;

public class PlusOneLinkedList {
	public ListNode plusOne(ListNode head) {
        if (head == null) return head;
        int sum = helper(head);
        if (sum == 1) {
            ListNode node = new ListNode(1);
            node.next = head;
            return node;
        } else {
            return head;
        }
    }
    
    int helper(ListNode curr) {
        if (curr == null) return 1;
        
        int currVal = curr.val;
        int nextLevel = helper(curr.next);
        int sum = currVal + nextLevel;
        curr.val = sum >= 10? sum-10 : sum;
        return sum >= 10? 1 : 0;
    }
}
