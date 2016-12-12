package Random;

public class LinkedListRandomNode {
	ListNode head;
    
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int count = 0;
        ListNode node = head;
        ListNode candidate = null;
        Random random = new Random();
        while(node != null) {
            count++;
            if (random.nextInt(count) == 0) candidate = node;
            node = node.next;
        }
        return candidate.val;
    }

}
