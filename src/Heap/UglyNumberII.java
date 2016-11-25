package Heap;

public class UglyNumberII {
	public int nthUglyNumber(int n) {
        if (n < 1) return 0;
        PriorityQueue<Long> q = new PriorityQueue<>();
        q.offer((long)1);
        while(true) {
            long curr = q.poll();
            n--;
            if (n == 0) return (int)curr;
            q.offer(2*curr);
            q.offer(3*curr);
            q.offer(5*curr);
            while(q.size() > 0 && q.peek() == curr) q.poll();
        }
    }
}
