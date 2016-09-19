package Passed;

public class DeleteNodeInALinkedList {
	public void deleteNode(ListNode node) {
        if (node == null) return;
        
        ListNode curr = node;
        while(curr.next != null) {
            curr.val = curr.next.val;
            if (curr.next.next == null) {
                curr.next = null;
                return;
            } else{
                curr = curr.next;
            }
        }
        return;
    }
}
