package Passed;

public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
        ListNode fakeNode = new ListNode(0);
        fakeNode.next = head;
        ListNode prev = fakeNode;
        ListNode curr = head;
        
        while(curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
                curr = curr.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return fakeNode.next;
    }
}
