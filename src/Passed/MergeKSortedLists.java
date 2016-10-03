package Passed;

public class MergeKSortedLists {
	 public ListNode mergeKLists(ListNode[] lists) {
	        if (lists == null || lists.length == 0) return null;
	        Queue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
	            public int compare(ListNode l1, ListNode l2) {
	                return l1.val - l2.val;
	            }
	        });
	        
	        ListNode head = new ListNode(0);
	        ListNode tail = head;
	        for(ListNode node : lists) {
	            if (node != null) queue.offer(node);
	        }
	        while(!queue.isEmpty()) {
	            tail.next = queue.poll();
	            tail = tail.next;
	            if (tail.next != null) queue.offer(tail.next);
	        }
	        return head.next;
	    }
}
