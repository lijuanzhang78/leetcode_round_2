package Passed;

public class DesignHitCounter {
	Queue<Integer> list;;

    /** Initialize your data structure here. */
    public HitCounter() {
        list = new LinkedList<Integer>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        list.offer(timestamp);
        if (timestamp - list.peek() >= 300) {
            list.poll();
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int count = 0;
        for(int num : list) {
            if (timestamp - num < 300) {
                count++;
            } 
        }
        return count;
    }
}
