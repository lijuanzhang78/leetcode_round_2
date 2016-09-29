package Passed;

class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
}

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        int carry = 0;
        ListNode fakeNode = new ListNode(0);
        ListNode prev = fakeNode;
        while(l1 != null || l2 != null) {
            int curr = carry;
            if (l1 != null) curr += l1.val;
            if (l2 != null) curr += l2.val;
            carry = curr/10;
            curr %= 10;
            prev.next = new ListNode(curr);
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            prev = prev.next;
        }
        if (carry != 0) {
            prev.next = new ListNode(carry);
        }
        return fakeNode.next;
    }
	
public static void main(String[] args) {
	ListNode node1 = new ListNode(2);
	ListNode node2 = new ListNode(4);
	ListNode node3 = new ListNode(3);
	node1.next = node2;
	node2.next = node3;
	ListNode l1 = node1;
	
	node1 = new ListNode(5);
	node2 = new ListNode(6);
	node3 = new ListNode(4);
	node1.next = node2;
	node2.next = node3;
	ListNode l2 = node1;
	
	ListNode res = new AddTwoNumbers().addTwoNumbers(l1, l2);	
}
}
