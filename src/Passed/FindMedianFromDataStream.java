package Passed;

public class FindMedianFromDataStream {
	PriorityQueue<Integer> min = new PriorityQueue<>((a,b) -> (a-b)); // for larger part
    PriorityQueue<Integer> max = new PriorityQueue<>((a,b) -> (b-a)); // for smaller part
    
    // Adds a number into the data structure.
    public void addNum(int num) {
        min.offer(num);
        max.offer(min.poll());
        if (min.size() < max.size()) min.offer(max.poll());
    }

    // Returns the median of current data stream
    public double findMedian() {
        return min.size() > max.size()? (double)min.peek() : (min.peek() + max.peek())/2.0;
    }
}
