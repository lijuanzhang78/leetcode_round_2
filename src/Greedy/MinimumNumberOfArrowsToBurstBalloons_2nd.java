package Greedy;

public class MinimumNumberOfArrowsToBurstBalloons_2nd {
	public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Arrays.sort(points, new Comparator<int[]>() {
		    public int compare(int[] a, int[] b) {
			    return a[0]-b[0];
		    }
	    });
        
        PriorityQueue<int[]> q = new PriorityQueue<int[]> ((a,b)->(b[1]-a[1]));
        q.offer(points[0]);
        
        for(int i = 1; i < points.length; i++) {
            int[] first = q.poll();
            if(points[i][0] <= first[1]) {
                first[0] = points[i][0];
                first[1] = Math.min(first[1],points[i][1]);
            } else {
                q.offer(points[i]);
            }
            q.offer(first);
        }
        return q.size();
    }
}
