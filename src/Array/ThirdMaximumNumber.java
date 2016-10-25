package Array;

public class ThirdMaximumNumber {
	public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(int num : nums) {
            if (!q.contains(num)) {
                q.offer(num);
            }
            if (q.size() > 3) q.poll();
        }
        if (q.size() < 3) {
            while(q.size() > 1) {
                q.poll();
            }
        }
        return q.peek();
    }
}
