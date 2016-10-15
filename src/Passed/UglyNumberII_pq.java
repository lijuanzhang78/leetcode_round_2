package Passed;

import java.util.PriorityQueue;

public class UglyNumberII_pq {
	public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<Long>();
        pq.add(1l);
        int count = 0;
        Long curr = 0l;
        while(count < n) {
            curr = pq.poll();
            System.out.println(curr);
            count++;
            pq.add(curr*2);
            pq.add(curr*3);
            pq.add(curr*5);
            while(!pq.isEmpty() && pq.peek().equals(curr)) pq.poll();
        }
        return curr.intValue();
    }
	
	public static void main(String[] args) {
		int res = new UglyNumberII_pq().nthUglyNumber(40);	
	}
}
