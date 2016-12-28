package Design;

// this is a solution that could scale up
//
public class DesignHitCounter {
	 int[] times;
	    int[] counts;
	    
	    /** Initialize your data structure here. */
	    public HitCounter() {
	        times = new int[300];
	        counts = new int[300];
	    }
	    
	    /** Record a hit.
	        @param timestamp - The current timestamp (in seconds granularity). */
	    public void hit(int timestamp) {
	        int index = timestamp%300;
	        if (times[index] == timestamp) {
	            counts[index]++;
	        } else {
	            times[index] = timestamp;
	            counts[index] = 1;
	        }
	    }
	    
	    /** Return the number of hits in the past 5 minutes.
	        @param timestamp - The current timestamp (in seconds granularity). */
	    public int getHits(int timestamp) {
	        int total = 0;
	        for(int i = 0; i < 300; i++) {
	            if (timestamp - times[i] < 300) {
	                total += counts[i];
	            }
	        }
	        return total;
	    }
}
