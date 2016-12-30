package Random;

public class LinkedListRandomNode_2nd {
	ListNode head;
    Random rand;
    
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        rand = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode res = null;
        ListNode curr = head;
        int count = 1;
        while(curr != null) {
            if (rand.nextInt(count) == 0) res = curr;
            curr = curr.next;
            count++;
        }
        return res.val;
    }
}
