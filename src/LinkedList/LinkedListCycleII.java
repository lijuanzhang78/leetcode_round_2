package LinkedList;

public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head, fast = head.next;
        while(slow != head) {
            if (fast == null || fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
