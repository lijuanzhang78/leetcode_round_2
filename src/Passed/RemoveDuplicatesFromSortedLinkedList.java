package Passed;

public class RemoveDuplicatesFromSortedLinkedList {
	public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr != null) {
            if (prev != null && curr.val == prev.val) {
                prev.next = curr.next;
                curr = curr.next;
                continue;
            }
            
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
}
