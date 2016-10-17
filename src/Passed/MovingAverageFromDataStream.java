package Passed;

public class MovingAverageFromDataStream {
	Queue<Integer> q;
    int max;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        q = new LinkedList<>();
        max = size;
    }
    
    public double next(int val) {
        q.offer(val);
        while (q.size() > max) {
            q.poll();
        }
        double sum = 0;
        for(int num : q) {
            sum += num;
        }
        return sum/q.size();
    }
}
