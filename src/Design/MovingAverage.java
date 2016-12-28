package Design;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
	Queue<Integer> q;
    double sum;
    int max;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        q = new LinkedList<Integer>();
        sum = 0;
        max = size;
    }
    
    public double next(int val) {
        sum += val;
        q.offer(val);
        if (q.size() > max) {
            int first = q.poll();
            sum -= first;
        }
        return sum/q.size();
    }
    
    public static void main(String[] args){
    	MovingAverage mv = new MovingAverage(3);
    	double res = mv.next(1);
    	res = mv.next(10);
    	res = mv.next(3);
    	res = mv.next(5);
    }
}
