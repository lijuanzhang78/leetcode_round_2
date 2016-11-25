package Heap;

public class SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        Deque<Integer> q = new ArrayDeque<Integer>();
        List<Integer> list = new ArrayList<>();
        int i = 0;
        for(i = 0; i < k; i++) {
            while(q.size() > 0 && q.peekLast() < nums[i]) {
                q.removeLast();
            }
            q.offer(nums[i]);
        }
        list.add(q.peekFirst());
        while(i < nums.length) {
            while(q.size() > 0 && q.peekLast() < nums[i]) {
                q.removeLast();
            }
            q.offer(nums[i]);
            if (nums[i-k] == q.peekFirst()) q.removeFirst(); 
            list.add(q.peekFirst());
            i++;
        } 
        int[] res = new int[list.size()];
        for(int j = 0; j < list.size(); j++) {
            res[j] = list.get(j);
        }
        return res;
    }
}
