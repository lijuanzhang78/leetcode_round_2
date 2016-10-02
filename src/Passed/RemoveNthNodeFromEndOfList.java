package Passed;

public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fakeNode = new ListNode(0);
        fakeNode.next = head;
        ListNode fast = fakeNode;
        ListNode slow = fakeNode;
        
        while(n > 0) {
            fast = fast.next;
            n--;
        }
        
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        return fakeNode.next;
    }
}
